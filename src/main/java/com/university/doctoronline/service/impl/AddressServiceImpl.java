package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.filter.BaseFilter;
import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.user.Address;
import com.university.doctoronline.filter.IdFilter;
import com.university.doctoronline.repository.AddressRepository;
import com.university.doctoronline.service.AddressService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl extends AbstractBaseCrudService<Address, IdFilter> implements AddressService {

    private final AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Example<Address> createExample(BaseFilter filter) {
        return null;
    }

    @Override
    public Optional<Address> findBy(String city, String street, String houseNumber, String apartment, String index) {
        return repository.findByCityAndStreetAndHouseNumberAndApartmentAndIndex(city, street, houseNumber, apartment, index);
    }
}
