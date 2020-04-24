package com.university.doctoronline.dto.converter;

import com.university.doctoronline.dto.AddressDto;
import com.university.doctoronline.entity.user.Address;
import com.university.doctoronline.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressDtoConverter implements DtoConverter<Address, AddressDto> {

    private final AddressService addressService;

    public AddressDtoConverter(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public Address toEntity(AddressDto dto) {
        if (dto == null) {
            return null;
        }
        return addressService.findBy(dto.getCity(), dto.getStreet(), dto.getHouseNumber(), dto.getApartment(), dto.getIndex())
                .orElseGet(() -> {
                    final var address = new Address();
                    address.setCity(dto.getCity());
                    address.setStreet(dto.getStreet());
                    address.setHouseNumber(dto.getHouseNumber());
                    address.setApartment(dto.getApartment());
                    address.setIndex(dto.getIndex());

                    return addressService.save(address);
                });
    }

    @Override
    public AddressDto toDto(Address entity) {
        if (entity == null) {
            return null;
        }
        final var dto = new AddressDto();
        dto.setId(entity.getId());
        dto.setCity(entity.getCity());
        dto.setStreet(entity.getStreet());
        dto.setHouseNumber(entity.getHouseNumber());
        dto.setApartment(entity.getApartment());
        dto.setIndex(entity.getIndex());

        return dto;
    }
}
