package com.backend.helper;

import java.io.Serializable;

/**
 * Created by sophon on 7/9/17.
 */
public interface AuditableEntity extends VersionFieldEntity, Status, Serializable {

    Auditable getAuditable();

    void setAuditable(Auditable auditable);

    Long getVersion();

    void setVersion(Long version);

}

