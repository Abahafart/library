package com.abahafart.domain.service;

import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.AddressDO;
import com.abahafart.domain.model.CountryDO;
import com.abahafart.domain.repository.AddressRepository;
import com.abahafart.domain.repository.CountryRepository;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
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
    Uni<List<CountryDO>> countryUniList = listAddress.log().onItem().ifNotNull().transformToUni(
        (addressList, uniEmitter) -> addressList.stream().map(this::fromAddress).toList());
    return Uni.combine().all().unis(listAddress, countryUniList)
        .with(this::createListAddress);
  }

  private List<AddressDO> createListAddress(List<AddressDO> addressList, List<CountryDO> countryList) {
    return addressList.stream().peek(addressDO -> countryList.forEach(countryDO -> {
      if (countryDO.getId() == addressDO.getIdCountry()) {
        addressDO.setCountry(countryDO);
      }
    })).toList();
  }

  private Uni<CountryDO> fromAddress(AddressDO addressDO) {
    return countryRepository.getById(addressDO.getIdCountry());
  }
}
