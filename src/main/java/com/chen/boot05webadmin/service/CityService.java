package com.chen.boot05webadmin.service;

import com.chen.boot05webadmin.bean.City;

public interface CityService {
    public City getById(Long id);
    public void saveCity(City city);
}
