package com.abahafart.infra.controller.request;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonRequest {

  private String name;
  private String surname;
  private String fullName;
  private LocalDate birthDate;
}
