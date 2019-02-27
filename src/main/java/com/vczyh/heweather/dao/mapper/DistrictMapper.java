package com.vczyh.heweather.dao.mapper;

import com.vczyh.heweather.domain.po.District;

import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    List<District> selectByCityId(int cityId);

    List<District> selectAll();

}