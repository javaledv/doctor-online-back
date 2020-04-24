package com.university.doctoronline.repository;

import com.reserver.common.starter.data.jpa.basecrud.repository.BaseCrudRepository;
import com.university.doctoronline.entity.user.Address;

import java.util.Optional;

public interface AddressRepository extends BaseCrudRepository<Address> {
    Optional<Address> findByCityAndStreetAndHouseNumberAndApartmentAndIndex(String city, String street, String houseNumber, String apartment, String index);
}
