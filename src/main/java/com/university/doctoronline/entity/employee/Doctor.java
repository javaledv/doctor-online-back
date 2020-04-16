package com.university.doctoronline.entity.employee;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Doctor extends Employee {

    @Column
    private String cabinet;

    @Column
    private String specialization;

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
