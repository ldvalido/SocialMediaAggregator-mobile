package ar.com.redbee.socialmediaaggregator.commons.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;

import ar.com.redbee.socialmediaaggregator.R;
import ar.com.redbee.socialmediaaggregator.commons.BaseActivity;
import ar.com.redbee.socialmediaaggregator.commons.linq.Action;

/**
 * Created by lvalido on 01/01/1900.
 */


public final class DialogHelper {
    /**
     * Build.
     *
     * @param activity the activity
     * @param title    the title
     * @param message  the message
     * @param action   the action
     */
    public static void Build(final Activity activity, String title, String message, final Action<Activity> action) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity);
        alertBuilder.setMessage(message)
                .setTitle(title)
                .setNeutralButton("OK",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        action.eval(activity);
                    }});
        final AppCompatDialog rangeDialog = alertBuilder.create();
        rangeDialog.show();
    }

    /**
     * Confirm.
     *
     * @param activity the activity
     * @param title    the title
     * @param message  the message
     * @param action   the action
     */
    public static void Confirm(final BaseActivity activity, String title, String message, final Action<BaseActivity> action) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity);
        alertBuilder.setMessage(message)
                .setTitle(title)
                .setNeutralButton(R.string.yes,new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        action.eval(activity);
                    }})
        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AppCompatDialog rangeDialog = alertBuilder.create();
        rangeDialog.show();
    }
}
