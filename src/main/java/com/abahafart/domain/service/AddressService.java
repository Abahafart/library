package com.abahafart.domain.service;

import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.AddressDO;

import io.smallrye.mutiny.Uni;

public interface AddressService {

  Uni<AddressDO> create(AddressDO addressDO);
  Uni<List<AddressDO>> findAll(Map<String, Object> filters);
}
