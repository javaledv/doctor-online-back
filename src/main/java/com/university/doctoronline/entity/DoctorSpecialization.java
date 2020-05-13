package com.university.doctoronline.entity;

import com.reserver.common.starter.data.jpa.basecrud.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class DoctorSpecialization extends BaseEntity {

    @Column(unique = true, nullable = false)
    private Integer code;

    @OneToMany
    private List<DoctorSpecializationLocalizedName> doctorSpecializationLocalizedNames;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<DoctorSpecializationLocalizedName> getDoctorSpecializationLocalizedNames() {
        return doctorSpecializationLocalizedNames;
    }

    public void setDoctorSpecializationLocalizedNames(List<DoctorSpecializationLocalizedName> doctorSpecializationLocalizedNames) {
        this.doctorSpecializationLocalizedNames = doctorSpecializationLocalizedNames;
    }
}
