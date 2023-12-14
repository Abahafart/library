package com.abahafart.infra.controller.response;

import java.time.Instant;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {

  private Long id;
  private String name;
  private String surname;
  private String fullName;
  private LocalDate birthDate;
  private Instant createdAt;
  private Instant updatedAt;
}
