package com.abahafart.infra.controller.filter;

import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryFilter {

  @QueryParam("id")
  private Long id;
  @QueryParam("name")
  private String name;
  @QueryParam("description")
  private String description;
  @QueryParam("shortVersion")
  private String shortVersion;
}
