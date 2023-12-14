package com.abahafart.infra.controller.filter;

import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonFilter {

  @QueryParam("id")
  private Long id;
  @QueryParam("name")
  private String name;
  @QueryParam("surname")
  private String surname;
  @QueryParam("fullname")
  private String fullname;
}
