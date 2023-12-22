package com.abahafart.infra.controller.filter;

import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressFilter {

  @QueryParam("id")
  private Long id;
  @QueryParam("street")
  private String street;
  @QueryParam("number")
  private String number;
  @QueryParam("neighborhood")
  private String neighborhood;
  @QueryParam("municipality")
  private String municipality;
  @QueryParam("state")
  private String state;
  @QueryParam("zipCode")
  private String zipCode;
  @QueryParam("idPerson")
  private long idPerson;
  @QueryParam("idCountry")
  private long idCountry;
}
