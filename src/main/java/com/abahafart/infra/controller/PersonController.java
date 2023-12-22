package com.abahafart.infra.controller;

import java.util.List;
import java.util.Map;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.Status;

import com.abahafart.domain.model.PersonDO;
import com.abahafart.domain.service.PersonService;
import com.abahafart.infra.controller.filter.PersonFilter;
import com.abahafart.infra.controller.mapper.GeneralMapper;
import com.abahafart.infra.controller.request.PersonRequest;
import com.abahafart.infra.controller.response.PersonResponse;
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
@Path("/persons")
@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

  private final PersonService service;
  private final ObjectMapper objectMapper;
  private final GeneralMapper generalMapper;

  @POST
  public Uni<RestResponse<PersonResponse>> create(PersonRequest request) {
    return service.create(generalMapper.buildPersonDO(request)).log().onItem().transform(personDO -> RestResponse.status(
        Status.CREATED, generalMapper.buildPersonResponse(personDO)));
  }

  @GET
  public Uni<RestResponse<List<PersonResponse>>> getById(@BeanParam PersonFilter personFilter) {
    Map<String, Object> filters = objectMapper.convertValue(personFilter, new TypeReference<>() {});
    return service.findAll(filters).onItem().transform(personList -> RestResponse.status(Status.OK,
        personList.stream().map(generalMapper::buildPersonResponse).toList()));
  }
}
