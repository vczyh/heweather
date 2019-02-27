package com.vczyh.heweather.dao.mapper;

import com.vczyh.heweather.domain.po.Province;

import java.util.List;

public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);

    Province selectByName(String name);

    List<Province> selectAll();
}