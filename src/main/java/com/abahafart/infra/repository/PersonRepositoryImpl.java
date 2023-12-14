package com.abahafart.infra.repository;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.abahafart.domain.model.PersonDO;
import com.abahafart.domain.repository.PersonRepository;
import com.abahafart.infra.repository.entity.PersonEntity;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class PersonRepositoryImpl implements PersonRepository, PanacheRepository<PersonEntity> {

  @Override
  public Uni<PersonDO> create(PersonDO personDO) {
    Uni<PersonEntity> created = Panache.withTransaction(() -> this.persist(buildEntity(personDO)));
    return created.onItem().transform(this::buildDO);
  }

  @Override
  public Uni<PersonDO> getById(long id) {
    Uni<PersonEntity> found = Panache.withTransaction(() -> this.findById(id));
    return found.onItem().transform(this::buildDO);
  }

  @Override
  public Uni<List<PersonDO>> findAllByName(String name) {
    Uni<List<PersonEntity>> listUni = Panache.withTransaction(() -> this.list("name", name));
    return listUni.onItem().transform(personList -> personList.stream().map(this::buildDO).toList());
  }

  @Override
  public Uni<List<PersonDO>> findAllByFullName(String fullName) {
    Uni<List<PersonEntity>> listUni = Panache.withTransaction(() -> this.list("fullName", fullName));
    return listUni.onItem().transform(personList -> personList.stream().map(this::buildDO).toList());
  }

  @Override
  public Uni<List<PersonDO>> findAllRecords(Map<String, Object> filters) {
    StringBuilder query = new StringBuilder();
    Map<String, Object> filtersWithOutNulls = filters.entrySet().stream().filter(entry -> entry.getValue() != null).collect(
        Collectors.toMap(Entry::getKey, Entry::getValue));
    filtersWithOutNulls.forEach((key, value) -> query.append(key.toLowerCase()).append(" = :").append(key.toLowerCase()).append(" and "));
    log.info("Query {}", query.substring(0, query.length()-5));
    Uni<List<PersonEntity>> listUni = Panache.withTransaction(() -> this.list(query.substring(0, query.length()-5), filtersWithOutNulls));
    return listUni.onItem().transform(personList -> personList.stream().map(this::buildDO).toList());
  }

  private PersonEntity buildEntity(PersonDO personDO) {
    return PersonEntity.builder()
        .birthDate(personDO.getBirthDate())
        .surname(personDO.getSurname())
        .createdAt(Instant.now())
        .fullName(personDO.getFullName())
        .updatedAt(Instant.now())
        .name(personDO.getName())
        .build();
  }

  private PersonDO buildDO(PersonEntity entity) {
    return PersonDO.builder()
        .birthDate(entity.getBirthDate())
        .surname(entity.getSurname())
        .createdAt(entity.getCreatedAt())
        .fullName(entity.getFullName())
        .name(entity.getName())
        .updatedAt(entity.getUpdatedAt())
        .id(entity.getId())
        .build();
  }
}
