package com.abahafart.domain.service;

import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.PersonDO;

import io.smallrye.mutiny.Uni;

public interface PersonService {

  Uni<PersonDO> create(PersonDO personDO);
  Uni<PersonDO> getById(long id);
  Uni<List<PersonDO>> findAllByName(String name);
  Uni<List<PersonDO>> findAllByFullName(String fullName);
  Uni<List<PersonDO>> findAll(Map<String, Object> filters);
}
