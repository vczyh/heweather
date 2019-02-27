package com.vczyh.heweather.service.impl;

import com.vczyh.heweather.dao.mapper.CityMapper;
import com.vczyh.heweather.domain.po.City;
import com.vczyh.heweather.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> getByProvinceId(int provinceId) {
        return cityMapper.selectByProvinceId(provinceId);
    }
}
