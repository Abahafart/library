package com.abahafart.domain.service;

import com.abahafart.domain.model.CountryDO;
import com.abahafart.domain.repository.CountryRepository;
import com.abahafart.infra.service.CountryService;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

  private final CountryRepository countryRepository;

  @Override
  public Uni<CountryDO> create(CountryDO countryDO) {
    return countryRepository.create(countryDO);
  }

  @Override
  public Uni<CountryDO> getByName(String name) {
    return countryRepository.getCountryByName(name);
  }
}
