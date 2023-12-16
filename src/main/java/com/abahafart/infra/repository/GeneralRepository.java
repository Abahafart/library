package com.abahafart.infra.repository;

import java.util.Map;

public interface GeneralRepository {

  Map<String, Object> withOutValuesNull(Map<String, Object> filters);
  String buildQuery(Map<String, Object> filters);
}
