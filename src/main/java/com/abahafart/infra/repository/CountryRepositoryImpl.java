package com.abahafart.infra.repository;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.CountryDO;
import com.abahafart.domain.repository.CountryRepository;
import com.abahafart.infra.repository.entity.CountryEntity;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CountryRepositoryImpl implements CountryRepository, PanacheRepository<CountryEntity> {

  private final GeneralRepository generalRepository;

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

  @Override
  public Uni<List<CountryDO>> findAllRecords(Map<String, Object> filters) {
    Map<String, Object> filtersWithOutNulls = generalRepository.withOutValuesNull(filters);
    String query = generalRepository.buildQuery(filtersWithOutNulls);
    Uni<List<CountryEntity>> listUni = this.list(query, filtersWithOutNulls);
    return listUni.onItem().transform(personList -> personList.stream().map(this::buildCountry).toList());
  }

  @Override
  public Uni<CountryDO> getById(Long id) {
    return this.findById(id).map(this::buildCountry);
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
