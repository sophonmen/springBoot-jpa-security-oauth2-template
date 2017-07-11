package com.backend.helper;

/**
 * Created by sophon on 7/9/17.
 */
public interface VersionFieldEntity {
    String COLUMN_NAME_VERSION = "version";

    Long getVersion();

    void setVersion(Long version);

}
