package com.chen.boot05webadmin.mapper;

import com.chen.boot05webadmin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City getById(Long id);

//    @Select("insert into city(`name`,`state`,`country`) value(#{name},#{state},#{country})")
//    @Options(useGeneratedKeys = true,keyProperty = "id")
//    public void insert(City city);
    public void insert(City city);

}
