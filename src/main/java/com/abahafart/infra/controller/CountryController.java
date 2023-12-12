package com.abahafart.infra.controller;

import java.time.Instant;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.Status;

import com.abahafart.domain.model.CountryDO;
import com.abahafart.infra.controller.request.CountryRequest;
import com.abahafart.infra.controller.response.CountryResponse;
import com.abahafart.infra.service.CountryService;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Path("/countries")
public class CountryController {

  private final CountryService service;

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Uni<RestResponse<CountryResponse>> create(CountryRequest request) {
    CountryDO countryDO = CountryDO.builder().name(request.getName())
        .shortVersion(request.getShortVersion())
        .description(request.getDescription())
        .createdAt(Instant.now())
        .updatedAt(Instant.now()).build();
    return service.create(countryDO).log().onItem().transform(countryDO1 -> RestResponse.status(
        Status.CREATED, CountryResponse.builder()
                .id(countryDO1.getId())
                .name(countryDO1.getName())
                .updatedAt(countryDO1.getUpdatedAt())
                .shortVersion(countryDO1.getShortVersion())
                .description(countryDO1.getDescription())
            .build()));
  }
}
