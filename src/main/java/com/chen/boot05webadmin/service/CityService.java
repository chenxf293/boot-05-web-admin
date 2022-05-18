package com.chen.boot05webadmin.service;

import com.chen.boot05webadmin.bean.City;
import com.chen.boot05webadmin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(Long id){
        return cityMapper.getById(id);
    }

    public void saveCity(City city){
        cityMapper.insert(city);
    }
}
