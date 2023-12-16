package com.abahafart.domain.repository;

import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.PersonDO;

import io.smallrye.mutiny.Uni;

public interface PersonRepository {

  Uni<PersonDO> create(PersonDO personDO);
  Uni<List<PersonDO>> findAllRecords(Map<String, Object> filters);
}
