package com.abahafart.infra.controller;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.abahafart.domain.model.AddressDO;
import com.abahafart.domain.service.AddressService;
import com.abahafart.infra.controller.filter.AddressFilter;
import com.abahafart.infra.controller.mapper.GeneralMapper;
import com.abahafart.infra.controller.request.AddressRequest;
import com.abahafart.infra.controller.response.AddressResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/addresses")
@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressController {

  private final AddressService addressService;
  private final GeneralMapper generalMapper;
  private final ObjectMapper objectMapper;

  @POST
  public Uni<AddressResponse> create(AddressRequest request) {
    AddressDO addressDO = generalMapper.buildAddressDO(request);
    return addressService.create(addressDO).onItem().ifNotNull().transform(generalMapper::buildAddressResponse);
  }

  @GET
  public Uni<List<AddressResponse>> findAllRecords(@BeanParam AddressFilter addressFilter) {
    Map<String, Object> addressFilters = objectMapper.convertValue(addressFilter, new TypeReference<>(){});
    Uni<List<AddressDO>> recordsFound = addressService.findAll(addressFilters);
    return recordsFound.onItem().ifNotNull().transform(list -> list.stream().map(generalMapper::buildAddressResponse).toList());
  }
}
