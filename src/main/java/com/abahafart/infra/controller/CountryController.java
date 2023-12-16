package com.abahafart.infra.controller;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.Status;

import com.abahafart.domain.model.CountryDO;
import com.abahafart.infra.controller.filter.CountryFilter;
import com.abahafart.infra.controller.request.CountryRequest;
import com.abahafart.infra.controller.response.CountryResponse;
import com.abahafart.domain.service.CountryService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path("/countries")
@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CountryController {

  private final CountryService service;
  private final ObjectMapper objectMapper;

  @POST
  public Uni<RestResponse<CountryResponse>> create(CountryRequest request) {
    CountryDO countryDO = CountryDO.builder().name(request.getName())
        .shortVersion(request.getShortVersion())
        .description(request.getDescription())
        .createdAt(Instant.now())
        .updatedAt(Instant.now()).build();
    return service.create(countryDO).log().onItem().transform(countryDO1 -> RestResponse.status(
        Status.CREATED, buildResponse(countryDO1)));
  }

  @GET
  public Uni<RestResponse<List<CountryResponse>>> findAll(@BeanParam CountryFilter countryFilter) {
    Map<String, Object> filters = objectMapper.convertValue(countryFilter, new TypeReference<>() {});
    return service.findAll(filters).onItem().transform(countryList -> RestResponse.status(Status.OK,
        countryList.stream().map(this::buildResponse).toList()));
  }

  private CountryResponse buildResponse(CountryDO countryDO) {
    return CountryResponse.builder()
        .id(countryDO.getId())
        .name(countryDO.getName())
        .updatedAt(countryDO.getUpdatedAt())
        .shortVersion(countryDO.getShortVersion())
        .description(countryDO.getDescription())
        .createdAt(countryDO.getCreatedAt())
        .build();
  }
}
