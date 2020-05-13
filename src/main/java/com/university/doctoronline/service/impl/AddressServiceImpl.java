package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.user.Address;
import com.university.doctoronline.search.IdSearchCriteria;
import com.university.doctoronline.repository.AddressRepository;
import com.university.doctoronline.service.AddressService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl extends AbstractBaseCrudService<Address, IdSearchCriteria> implements AddressService {

    private final AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Optional<Address> findBy(String city, String street, String houseNumber, String apartment, String index) {
        return repository.findByCityAndStreetAndHouseNumberAndApartmentAndIndex(city, street, houseNumber, apartment, index);
    }

    @Override
    public Specification<Address> createSpecification(IdSearchCriteria searchCriteria) {
        return null;
    }
}
