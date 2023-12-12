package com.abahafart.infra.service;

import com.abahafart.domain.model.CountryDO;

import io.smallrye.mutiny.Uni;

public interface CountryService {

  Uni<CountryDO> create(CountryDO countryDO);
}
