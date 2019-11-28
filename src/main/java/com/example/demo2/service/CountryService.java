package com.example.demo2.service;

import java.util.List;

import com.example.demo2.entity.Country;

public interface CountryService {

	Country getByCode(String code);

	List<Country> saveFromCsv(String file);

}
