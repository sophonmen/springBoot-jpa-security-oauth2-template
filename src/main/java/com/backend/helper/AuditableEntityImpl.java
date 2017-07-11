package com.backend.helper;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

/**
 * Created by sophon on 7/9/17.
 */
@MappedSuperclass
public class AuditableEntityImpl implements AuditableEntity {

    @Embedded
    protected ArchiveStatus archiveStatus = new ArchiveStatus();

    @Embedded
    protected Auditable auditable = new Auditable();

    @Column(name = "AUDIT_VERSION")
    protected Long version;

    @Override
    public Character getArchived() {
        if (archiveStatus == null) {
            archiveStatus = new ArchiveStatus();
        }
        return archiveStatus.getArchived();
    }

    @Override
    public void setArchived(Character archived) {
        if (archiveStatus == null) {
            archiveStatus = new ArchiveStatus();
        }
        archiveStatus.setArchived(archived);
    }

    @Override
    public boolean isActive() {
        return 'Y' != getArchived();
    }

    public ArchiveStatus getArchiveStatus() {
        return archiveStatus;
    }

    public void setArchiveStatus(ArchiveStatus archiveStatus) {
        this.archiveStatus = archiveStatus;
    }

    public Auditable getAuditable() {
        return auditable;
    }

    public void setAuditable(Auditable auditable) {
        this.auditable = auditable;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
