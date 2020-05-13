package com.university.doctoronline.entity;

import com.reserver.common.starter.data.jpa.basecrud.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DoctorSpecializationLocalizedName extends BaseEntity {

    @Column
    private String locale;

    @Column
    private String name;

    @ManyToOne
    private DoctorSpecialization doctorSpecialization;

    public DoctorSpecialization getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(DoctorSpecialization doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
