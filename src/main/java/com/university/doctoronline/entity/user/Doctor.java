package com.university.doctoronline.entity.user;

import com.university.doctoronline.entity.DoctorSpecialization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Doctor extends User {

    @Column
    private String cabinet;

    @OneToOne
    private DoctorSpecialization doctorSpecialization;

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public DoctorSpecialization getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(DoctorSpecialization specialization) {
        this.doctorSpecialization = specialization;
    }
}
