package com.vczyh.heweather.dao.mapper;

import com.vczyh.heweather.domain.po.ChinaCity;

import java.util.List;

public interface ChinaCityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChinaCity record);

    int insertSelective(ChinaCity record);

    ChinaCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChinaCity record);

    int updateByPrimaryKey(ChinaCity record);

    ChinaCity selectByCityId(String cityId);

    List<ChinaCity> selectAll();

}