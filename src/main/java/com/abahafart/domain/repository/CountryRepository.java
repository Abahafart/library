package com.abahafart.domain.repository;

import java.util.List;

import com.abahafart.domain.model.CountryDO;

import io.smallrye.mutiny.Uni;

public interface CountryRepository {

  Uni<CountryDO> getCountryByName(String name);
  Uni<CountryDO> getById(long id);
  Uni<List<CountryDO>> findAllRecords();
  Uni<CountryDO> create(CountryDO country);
}
