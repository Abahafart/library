package com.abahafart.infra.repository;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class GeneralRepositoryImpl implements GeneralRepository {

  @Override
  public String buildQuery(Map<String, Object> filters) {
    StringBuilder query = new StringBuilder();
    Map<String, Object> filtersWithOutNulls = filters.entrySet().stream().filter(entry -> entry.getValue() != null).collect(
        Collectors.toMap(Entry::getKey, Entry::getValue));
    filtersWithOutNulls.forEach((key, value) -> query.append(key.toLowerCase()).append(" = :").append(key.toLowerCase()).append(" and "));
    log.info("Query {}", query.substring(0, query.length()-5));
    return query.substring(0, query.length()-5);
  }

  @Override
  public Map<String, Object> withOutValuesNull(Map<String, Object> filters) {
    return filters.entrySet().stream().filter(entry -> entry.getValue() != null).collect(
        Collectors.toMap(Entry::getKey, Entry::getValue));
  }
}
