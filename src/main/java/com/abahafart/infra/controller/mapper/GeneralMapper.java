package com.abahafart.infra.controller.mapper;

import java.time.Instant;

import com.abahafart.domain.model.AddressDO;
import com.abahafart.domain.model.CountryDO;
import com.abahafart.domain.model.PersonDO;
import com.abahafart.infra.controller.request.AddressRequest;
import com.abahafart.infra.controller.request.PersonRequest;
import com.abahafart.infra.controller.response.AddressResponse;
import com.abahafart.infra.controller.response.CountryResponse;
import com.abahafart.infra.controller.response.PersonResponse;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GeneralMapper {

  public AddressDO buildAddressDO(AddressRequest request) {
    return AddressDO.builder()
        .state(request.getState())
        .idCountry(request.getIdCountry())
        .number(request.getNumber())
        .zipCode(request.getZipCode())
        .idPerson(request.getIdPerson())
        .municipality(request.getMunicipality())
        .neighborhood(request.getNeighborhood())
        .createdAt(Instant.now())
        .build();
  }

  public CountryResponse buildCountryResponse(CountryDO countryDO) {
    return CountryResponse.builder()
        .id(countryDO.getId())
        .name(countryDO.getName())
        .updatedAt(countryDO.getUpdatedAt())
        .shortVersion(countryDO.getShortVersion())
        .description(countryDO.getDescription())
        .createdAt(countryDO.getCreatedAt())
        .build();
  }

  public PersonDO buildPersonDO(PersonRequest request) {
    return PersonDO.builder()
        .surname(request.getSurname())
        .birthDate(request.getBirthDate())
        .fullName(request.getFullName())
        .name(request.getName())
        .build();
  }

  public PersonResponse buildPersonResponse(PersonDO personDO) {
    return PersonResponse.builder()
        .id(personDO.getId())
        .name(personDO.getName())
        .birthDate(personDO.getBirthDate())
        .surname(personDO.getSurname())
        .fullName(personDO.getFullName())
        .createdAt(personDO.getCreatedAt())
        .updatedAt(personDO.getUpdatedAt())
        .build();
  }

  public AddressResponse buildAddressResponse(AddressDO addressDO) {
    AddressResponse response = AddressResponse.builder()
        .idPerson(addressDO.getIdPerson())
        .number(addressDO.getNumber())
        .state(addressDO.getState())
        .street(addressDO.getStreet())
        .zipCode(addressDO.getZipCode())
        .neighborhood(addressDO.getNeighborhood())
        .idCountry(addressDO.getIdCountry())
        .municipality(addressDO.getMunicipality())
        .id(addressDO.getId())
        .createdAt(addressDO.getCreatedAt())
        .build();
    if (addressDO.getCountry() != null) {
      response.setCountry(buildCountryResponse(addressDO.getCountry()));
    }
    if (addressDO.getPerson() != null) {
      response.setPerson(buildPersonResponse(addressDO.getPerson()));
    }
    return response;
  }
}
