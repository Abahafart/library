package com.abahafart.infra.controller;

import java.time.Instant;

import com.abahafart.domain.model.AddressDO;
import com.abahafart.infra.controller.request.AddressRequest;
import com.abahafart.infra.controller.response.AddressResponse;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/countries")
@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressController {

  @POST
  public Uni<AddressResponse> create(AddressRequest request) {
    return null;
  }

  private AddressDO fromRequest(AddressRequest request) {
    return AddressDO.builder()
        .state(request.getState())
        .idCountry(request.getIdCountry())
        .number(request.getNumber())
        .zipCode(request.getZipCode())
        .idPerson(request.getIdPerson())
        .municipality(request.getMunicipality())
        .neighborhood(request.getNeighborhood())
        .createdAt(Instant.now())
        .build();
  }
}
