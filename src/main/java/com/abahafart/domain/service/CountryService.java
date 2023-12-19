package com.abahafart.domain.service;

import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.CountryDO;

import io.smallrye.mutiny.Uni;

public interface CountryService {

  Uni<CountryDO> create(CountryDO countryDO);
  Uni<List<CountryDO>> findAll(Map<String, Object> filters);
  Uni<CountryDO> getById(Long id);
}
