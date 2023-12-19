package com.abahafart.infra.repository;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.PersonDO;
import com.abahafart.domain.repository.PersonRepository;
import com.abahafart.infra.repository.entity.PersonEntity;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository, PanacheRepository<PersonEntity> {

  private final GeneralRepository generalRepository;

  @Override
  public Uni<PersonDO> create(PersonDO personDO) {
    Uni<PersonEntity> created = Panache.withTransaction(() -> this.persist(buildEntity(personDO)));
    return created.onItem().transform(this::buildDO);
  }

  @Override
  public Uni<List<PersonDO>> findAllRecords(Map<String, Object> filters) {
    Map<String, Object> filtersWithOutNulls = generalRepository.withOutValuesNull(filters);
    String query = generalRepository.buildQuery(filtersWithOutNulls);
    Uni<List<PersonEntity>> listUni = Panache.withTransaction(() -> this.list(query, filtersWithOutNulls));
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
