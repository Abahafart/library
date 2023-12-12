package com.abahafart.infra.controller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryRequest {

  private String name;
  private String description;
  private String shortVersion;
}
