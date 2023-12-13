package com.abahafart.infra.service;

import java.util.List;

import com.abahafart.domain.model.CountryDO;

import io.smallrye.mutiny.Uni;

public interface CountryService {

  Uni<CountryDO> create(CountryDO countryDO);
  Uni<CountryDO> getByName(String name);
  Uni<List<CountryDO>> findAllRecords();
  Uni<CountryDO> getById(long id);
}
