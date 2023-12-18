package com.abahafart.domain.repository;

import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.AddressDO;
import io.smallrye.mutiny.Uni;

public interface AddressRepository {

  Uni<AddressDO> create(AddressDO address);
  Uni<List<AddressDO>> findAllRecords(Map<String, Object> filters);
}
