package com.abahafart.domain.repository;

import java.util.List;

import com.abahafart.domain.model.AddressDO;
import io.smallrye.mutiny.Uni;

public interface AddressRepository {

  Uni<AddressDO> getAddressByPersonId(long idPerson);
  Uni<AddressDO> create(AddressDO address);
  Uni<List<AddressDO>> getAddressByCountryId(long idCountry);
}
