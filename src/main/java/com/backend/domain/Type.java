package com.backend.domain;

import com.backend.helper.AuditableEntity;

/**
 * Created by sophon on 7/9/17.
 */
public interface Type extends AuditableEntity {
    public static final String TABLE_NAME = "types";

    Long getId();

    void setId(Long id);

    String getType();

    void setType(String type);
}
