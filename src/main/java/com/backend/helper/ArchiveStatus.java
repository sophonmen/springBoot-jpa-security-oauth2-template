package com.backend.helper;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by sophon on 7/9/17.
 */
@Embeddable
public class ArchiveStatus implements Serializable {
    public static final Character N = 'N';
    public static final Character Y = 'Y';

    @Column(name = "ARCHIVED")
    protected Character archived = 'N';

    public Character getArchived() {
        return archived;
    }

    public void setArchived(Character archived) {
        this.archived = archived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!getClass().isAssignableFrom(o.getClass())) {
            return false;
        }

        ArchiveStatus that = (ArchiveStatus) o;

        if (archived != null ? !archived.equals(that.archived) : that.archived != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return archived != null ? archived.hashCode() : 0;
    }
}
