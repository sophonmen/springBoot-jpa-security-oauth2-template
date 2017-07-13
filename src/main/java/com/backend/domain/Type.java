package com.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import com.backend.helper.AuditableEntityImpl;
import com.backend.helper.AuditableListener;

/**
 * Created by sophon on 7/9/17.
 */
@Entity
@Table(name = Type.TABLE_NAME)
@SQLDelete(sql = "UPDATE types SET ARCHIVED = 'Y' WHERE TYPE_ID = ?")
@EntityListeners(AuditableListener.class)
public class Type extends AuditableEntityImpl implements Serializable {
    public static final String TABLE_NAME = "types";
    private static final long serialVersionUID = - 4229274924175321832L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TYPE_ID")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
