package com.abahafart.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusDO {

  private String description;
  private String type;
  private String createdAt;
}
