package com.vczyh.heweather.dao.mapper;

import com.vczyh.heweather.domain.po.City;

import java.util.List;

public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    List<City> selectAll();

    List<City> selectByProvinceId(int provinceId);

    City selectByCode(String code);

    City selectByName(String name);

    City selectByNameAndCode(String name, String code);


}