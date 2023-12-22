package com.abahafart.domain.service;

import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.PersonDO;
import com.abahafart.domain.repository.PersonRepository;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  @Override
  @WithSession
  public Uni<PersonDO> create(PersonDO personDO) {
    return personRepository.create(personDO);
  }

  @Override
  @WithSession
  public Uni<List<PersonDO>> findAll(Map<String, Object> filters) {
    return personRepository.findAllRecords(filters);
  }
}
