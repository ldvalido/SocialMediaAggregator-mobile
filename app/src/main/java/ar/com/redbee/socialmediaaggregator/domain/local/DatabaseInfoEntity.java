package ar.com.redbee.socialmediaaggregator.domain.local;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ar.com.redbee.socialmediaaggregator.repository.commons.Identifiable;

@DatabaseTable
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseInfoEntity implements Identifiable {

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private Integer oldVersion;
    @DatabaseField
    private Integer newVersion;
    @DatabaseField
    private Boolean onlyThisVersion;
    @DatabaseField
    private Boolean migrationPending;

    /**
     * Instantiates a new Database info entity.
     */
    public DatabaseInfoEntity() {

    }

    /**
     * Instantiates a new Database info entity.
     *
     * @param oldVersion the old version
     * @param newVersion the new version
     */
    public DatabaseInfoEntity(Integer oldVersion, Integer newVersion) {
        this.oldVersion = oldVersion;
        this.newVersion = newVersion;
        this.onlyThisVersion = true;
        this.migrationPending = true;
    }


    /**
     * Gets old version.
     *
     * @return the old version
     */
    public Integer getOldVersion() {
        return oldVersion;
    }

    /**
     * Sets old version.
     *
     * @param oldVersion the old version
     */
    public void setOldVersion(Integer oldVersion) {
        this.oldVersion = oldVersion;
    }

    /**
     * Gets new version.
     *
     * @return the new version
     */
    public Integer getNewVersion() {
        return newVersion;
    }

    /**
     * Sets new version.
     *
     * @param newVersion the new version
     */
    public void setNewVersion(Integer newVersion) {
        this.newVersion = newVersion;
    }

    /**
     * Is migration pending boolean.
     *
     * @return the boolean
     */
    public Boolean isMigrationPending() {
        return migrationPending;
    }

    /**
     * Gets only this version.
     *
     * @return the only this version
     */
    public Boolean getOnlyThisVersion() {
        return onlyThisVersion;
    }

    /**
     * Sets only this version.
     *
     * @param onlyThisVersion the only this version
     */
    public void setOnlyThisVersion(Boolean onlyThisVersion) {
        this.onlyThisVersion = onlyThisVersion;
    }

    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Gets migration pending.
     *
     * @return the migration pending
     */
    public Boolean getMigrationPending() {
        return migrationPending;
    }

    /**
     * Sets migration pending.
     *
     * @param migrationPending the migration pending
     */
    public void setMigrationPending(Boolean migrationPending) {
        this.migrationPending = migrationPending;
    }

    /**
     * Has new version boolean.
     *
     * @return the boolean
     */
    public boolean hasNewVersion() {
        return newVersion != null && !newVersion.equals(oldVersion);
    }
}
