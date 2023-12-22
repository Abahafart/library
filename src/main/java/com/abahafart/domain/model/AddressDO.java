package com.abahafart.domain.model;

import java.time.Instant;

import io.smallrye.mutiny.Uni;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDO {

  private long id;
  private String street;
  private String number;
  private String neighborhood;
  private String municipality;
  private String state;
  private String zipCode;
  private Instant createdAt;
  private long idPerson;
  private long idCountry;
  private CountryDO country;
  private PersonDO person;
}
