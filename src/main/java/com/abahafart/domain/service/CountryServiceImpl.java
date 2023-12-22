package com.abahafart.domain.service;

import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.CountryDO;
import com.abahafart.domain.repository.CountryRepository;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
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
  @WithSession
  public Uni<CountryDO> create(CountryDO countryDO) {
    return countryRepository.create(countryDO);
  }

  @Override
  @WithSession
  public Uni<List<CountryDO>> findAll(Map<String, Object> filters) {
    return countryRepository.findAllRecords(filters);
  }

  @Override
  @WithSession
  public Uni<CountryDO> getById(Long id) {
    return null;
  }
}
