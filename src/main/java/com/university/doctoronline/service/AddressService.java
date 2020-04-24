package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.user.Address;
import com.university.doctoronline.filter.IdFilter;

import java.util.Optional;

public interface AddressService extends BaseCrudService<Address, IdFilter> {

    Optional<Address> findBy(String city, String street, String houseNumber, String apartment, String index);

}
