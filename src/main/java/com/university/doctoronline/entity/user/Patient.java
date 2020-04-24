package com.university.doctoronline.entity.user;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Patient extends User {

    @ManyToOne
    private Address address;

    @Column
    private LocalDateTime birthDate;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addres) {
        this.address = addres;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
