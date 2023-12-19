package com.abahafart.domain.repository;

import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.CountryDO;

import io.smallrye.mutiny.Uni;

public interface CountryRepository {
  Uni<CountryDO> create(CountryDO country);
  Uni<List<CountryDO>> findAllRecords(Map<String, Object> filters);
  Uni<CountryDO> getById(Long id);
}
