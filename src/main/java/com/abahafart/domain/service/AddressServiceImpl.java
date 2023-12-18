package com.abahafart.domain.service;

import static com.abahafart.domain.service.constants.ConstantService.ID_COUNTRY;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.AddressDO;
import com.abahafart.domain.model.CountryDO;
import com.abahafart.domain.repository.AddressRepository;
import com.abahafart.domain.repository.CountryRepository;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;
  private final CountryRepository countryRepository;

  @Override
  public Uni<AddressDO> create(AddressDO addressDO) {
    return addressRepository.create(addressDO);
  }

  @Override
  public Uni<List<AddressDO>> findAll(Map<String, Object> filters) {
    Uni<List<AddressDO>> listAddress = addressRepository.findAllRecords(filters);
    if (filters.containsKey(ID_COUNTRY)) {
      Map<String, Object> countryFilter = new HashMap<>();
      countryFilter.put(ID_COUNTRY, filters.get(ID_COUNTRY));
      Uni<List<CountryDO>> listCountries = countryRepository.findAllRecords(countryFilter);
    }
    return null;
  }
}
