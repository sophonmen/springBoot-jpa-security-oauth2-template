package com.backend.helper;

import java.util.Date;

/**
 * Created by sophon on 7/9/17.
 */
public interface Audit {

    Date getDateCreated();

    Date getDateUpdated();

    void setDateCreated(Date dateCreated);

    void setDateUpdated(Date dateUpdated);

    Long getCreatedBy();

    void setCreatedBy(Long createdBy);

    Long getUpdatedBy();

    void setUpdatedBy(Long updatedBy);

}
