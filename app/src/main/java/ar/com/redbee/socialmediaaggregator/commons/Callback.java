package ar.com.redbee.socialmediaaggregator.commons;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import ar.com.redbee.socialmediaaggregator.commons.linq.Action;
import ar.com.redbee.socialmediaaggregator.commons.linq.ListUtils;
import ar.com.redbee.socialmediaaggregator.commons.parser.JsonObjectMapperParser;

public abstract class Callback<T> {
    Exception error;

    public final Exception getError() {
        return error;
    }

    public final void execute() {
        execute(null);
    }

    public abstract void execute(T data);

    //Utils Methods
    public String getErrorMessage() {
        return error != null ? error.getMessage() : "";
    }

    protected boolean hasError() {
        return error != null;
    }

    protected boolean handleError(Callback callback) {
        boolean hasError = hasError();

        if (callback != null) {
            callback.error = null;

            if (hasError) {
                callback.fireError(error);
            }
        }

        return hasError;
    }

    public void fireError(Exception err) {
        if (err == null)
            err = new Exception();

        error = err;
        execute(null);
    }

    //Extends
    public static abstract class HttpService<T> extends Callback<T> {
        private int status;

        @Override
        public final void execute(T data) {
            execute(HttpURLConnection.HTTP_OK, data);
        }

        @Override
        public void fireError(Exception err) {
            fireError(HttpURLConnection.HTTP_INTERNAL_ERROR, err);
        }

        @Override
        protected boolean handleError(Callback callback) {
            boolean hasError = hasError();

            if (callback != null) {
                callback.error = null;

                if (hasError) {
                    if (callback instanceof HttpService)
                        ((HttpService) callback).fireError(status, error);
                    else
                        callback.fireError(error);
                }
            }

            return hasError;
        }

        public abstract void execute(int status, T data);

        public void fireError(int sts, Exception err) {
            if (err == null)
                err = new Exception();

            error = err;
            status = sts;
            execute(status, null);
        }
    }

    public static class JsonHttpService<T> extends HttpService<String> {
        private Callback<T> callback;

        public JsonHttpService(Callback<T> callback) {
            this.callback = callback;
        }

        protected T mapper(Class<T> clazz, String data) {
            return new JsonObjectMapperParser(clazz).parse(data);
        }

        private void send(int status, T response) {
            if (callback instanceof HttpService)
                ((HttpService<T>) callback).execute(status, response);
            else
                callback.execute(response);
        }

        @Override
        public void execute(int status, String data) {
            if (handleError(callback))
                return;

            Class<T> clazz = getDataClass(callback.getClass());
            if (clazz != null) {
                T response = mapper(clazz, data);
                send(status, response);

            } else {
                send(status, null);
            }
        }

        protected Class getDataClass(Class rootClass) {
            Object genericSuperClass = rootClass.getGenericSuperclass();
            if (genericSuperClass instanceof ParameterizedType) {
                return (Class) ((ParameterizedType) genericSuperClass).getActualTypeArguments()[0];
            }
            return null;
        }
    }

    public static class JsonListHttpService<T> extends JsonHttpService<List<T>> {
        public JsonListHttpService(Callback<List<T>> callback) {
            super(callback);
        }

        @Override
        protected Class getDataClass(Class rootClass) {
            Object genericSuperClass = rootClass.getGenericSuperclass();
            if (genericSuperClass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperClass;
                Type type = parameterizedType.getActualTypeArguments()[0];

                if (type instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) type;
                    return (Class) parameterizedType.getActualTypeArguments()[0];
                }
            }
            return null;
        }

        @Override
        protected List<T> mapper(Class<List<T>> clazz, String data) {
            return (List<T>) new JsonObjectMapperParser(clazz).parseCollection(data);
        }
    }

    public static final class OnceRunVariousCallback<T> extends Callback<T> {
        private List<Callback<T>> callbackList = new ArrayList<>();
        private boolean running = false;

        @Override
        public void execute(final T data) {
            synchronized (callbackList) {
                ListUtils.each(callbackList, new Action<Callback<T>>() {
                    @Override
                    public void eval(Callback<T> callback) {
                        if (callback != null) {
                            callback.error = error;
                            callback.execute(data);
                        }
                    }
                });
                callbackList.clear();
                running = false;
            }
        }

        public void addCallback(Callback<T> callback) {
            synchronized (callbackList) {
                callbackList.add(callback);
            }
        }

        public boolean isRunning() {
            return running;
        }

        public void start() {
            running = true;
        }
    }

    public static abstract class WaitCountCallback<T> extends Callback<T> {
        private List<T> result;
        private List<Exception> errors;

        private int count;

        public WaitCountCallback(int c) {
            result = new ArrayList<>(c);
            errors = new ArrayList<>(c);
            count = c;
        }

        @Override
        public void execute(T data) {
            synchronized (result) {
                count--;
                result.add(data);
                errors.add(error);

                if (count == 0)
                    finish();
            }
        }

        protected abstract void finish();
    }
}
