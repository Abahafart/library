package com.abahafart.infra.repository;

import java.time.Instant;
import java.util.List;

import com.abahafart.domain.model.CountryDO;
import com.abahafart.domain.repository.CountryRepository;
import com.abahafart.infra.repository.entity.CountryEntity;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountryRepositoryImpl implements CountryRepository {

  @Override
  public Uni<CountryDO> getCountryByName(String name) {
    Uni<CountryEntity> countryEntityUni = CountryEntity.find("name", name).firstResult();
    return countryEntityUni.onItem().transform(this::buildCountry);
  }

  @Override
  public Uni<CountryDO> getById(long id) {
    Uni<CountryEntity> countryEntityUni = CountryEntity.findById(id);
    return countryEntityUni.onItem().transform(this::buildCountry);
  }

  @Override
  public Uni<List<CountryDO>> findAll() {
    Uni<List<CountryEntity>> allRecords = CountryEntity.listAll(Sort.by("name"));
    return allRecords.onItem().transform(countryEntities ->
      countryEntities.stream().map(this::buildCountry).toList());
  }

  @Override
  public Uni<CountryDO> create(CountryDO country) {
    CountryEntity entity = new CountryEntity();
    entity.setCreatedAt(Instant.now());
    entity.setName(country.getName());
    entity.setDescription(country.getDescription());
    entity.setShortVersion(country.getShortVersion());
    Uni<CountryEntity> created = Panache.withTransaction(entity::persist);
    return created.onItem().transform(this::buildCountry);
  }

  private CountryDO buildCountry(CountryEntity entity) {
    return CountryDO.builder()
        .updatedAt(entity.getUpdatedAt())
        .shortVersion(entity.getShortVersion())
        .description(entity.getDescription())
        .createdAt(entity.getCreatedAt())
        .id(entity.id)
        .name(entity.getName())
        .build();
  }
}
