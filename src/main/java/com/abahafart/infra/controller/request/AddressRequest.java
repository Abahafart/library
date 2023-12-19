package com.abahafart.infra.controller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressRequest {

  private String street;
  private String number;
  private String neighborhood;
  private String municipality;
  private String state;
  private String zipCode;
  private long idPerson;
  private long idCountry;
}
