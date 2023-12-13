package com.abahafart.infra.repository;

import java.time.Instant;
import java.util.List;

import com.abahafart.domain.model.CountryDO;
import com.abahafart.domain.repository.CountryRepository;
import com.abahafart.infra.repository.entity.CountryEntity;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountryRepositoryImpl implements CountryRepository, PanacheRepository<CountryEntity> {

  @Override
  @WithSession
  public Uni<CountryDO> getCountryByName(String name) {
    Uni<CountryEntity> countryEntityUni = this.find("name", name).firstResult();
    return countryEntityUni.onItem().transform(this::buildCountry);
  }

  @Override
  @WithSession
  public Uni<CountryDO> getById(long id) {
    Uni<CountryEntity> countryEntityUni = this.findById(id);
    return countryEntityUni.onItem().transform(this::buildCountry);
  }

  @Override
  @WithSession
  public Uni<List<CountryDO>> findAllRecords() {
    Uni<List<CountryEntity>> allRecords = this.listAll(Sort.by("name"));
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
    entity.setUpdatedAt(Instant.now());
    Uni<CountryEntity> created = Panache.withTransaction(() -> this.persist(entity));
    return created.onItem().transform(this::buildCountry);
  }

  private CountryDO buildCountry(CountryEntity entity) {
    if (entity == null) {
      return CountryDO.builder().build();
    }
    return CountryDO.builder()
        .updatedAt(entity.getUpdatedAt())
        .shortVersion(entity.getShortVersion())
        .description(entity.getDescription())
        .createdAt(entity.getCreatedAt())
        .id(entity.getId())
        .name(entity.getName())
        .build();
  }
}
