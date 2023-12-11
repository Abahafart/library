package com.abahafart.domain.model;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NationalityPersonDO {

  private Instant createdAt;
  private Instant updatedAt;
  private PersonDO person;
  private CountryDO country;
}
