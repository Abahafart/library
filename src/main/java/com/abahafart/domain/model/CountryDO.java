package com.abahafart.domain.model;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDO {

  private Long id;
  private String name;
  private String description;
  private String shortVersion;
  private Instant createdAt;
  private Instant updatedAt;
}
