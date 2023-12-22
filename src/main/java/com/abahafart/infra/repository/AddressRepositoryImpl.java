package com.abahafart.infra.repository;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.AddressDO;
import com.abahafart.domain.repository.AddressRepository;
import com.abahafart.infra.repository.entity.AddressEntity;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository, PanacheRepository<AddressEntity> {

  private final GeneralRepository generalRepository;

  @Override
  public Uni<AddressDO> create(AddressDO address) {
    AddressEntity entity = new AddressEntity();
    entity.setCreatedAt(Instant.now());
    entity.setIdPerson(address.getIdPerson());
    entity.setIdCountry(address.getIdCountry());
    entity.setMunicipality(address.getMunicipality());
    entity.setNumber(address.getNumber());
    entity.setNeighborhood(address.getNeighborhood());
    entity.setState(address.getState());
    entity.setStreet(address.getStreet());
    entity.setZipCode(address.getZipCode());
    Uni<AddressEntity> created = Panache.withTransaction(() -> this.persist(entity));
    return created.onItem().transform(this::buildAddress);
  }

  @Override
  public Uni<List<AddressDO>> findAllRecords(Map<String, Object> filters) {
    Map<String, Object> withOutNulls = generalRepository.withOutValuesNull(filters);
    String query = generalRepository.buildQuery(withOutNulls);
    Uni<List<AddressEntity>> listAddress = Panache.withTransaction(() -> this.list(query, withOutNulls));
    return listAddress.log().onItem().transform(addressEntities -> addressEntities.stream().map(this::buildAddress).toList());
  }

  private AddressDO buildAddress(AddressEntity entity) {
    return AddressDO.builder()
        .id(entity.getId())
        .state(entity.getState())
        .street(entity.getStreet())
        .number(entity.getNumber())
        .zipCode(entity.getZipCode())
        .neighborhood(entity.getNeighborhood())
        .municipality(entity.getMunicipality())
        .createdAt(entity.getCreatedAt())
        .idCountry(entity.getIdCountry())
        .idPerson(entity.getIdPerson())
        .build();
  }
}
