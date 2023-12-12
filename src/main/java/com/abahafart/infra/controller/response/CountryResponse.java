package com.abahafart.infra.controller.response;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryResponse {

  private Long id;
  private String name;
  private String description;
  private String shortVersion;
  private Instant createdAt;
  private Instant updatedAt;
}
