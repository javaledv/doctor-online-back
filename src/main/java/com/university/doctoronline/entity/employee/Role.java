package com.university.doctoronline.entity.employee;

import com.reserver.common.starter.data.jpa.basecrud.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Role extends BaseEntity {

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String role) {
        this.name = role;
    }
}
