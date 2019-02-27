package com.vczyh.heweather.service.impl;

import com.vczyh.heweather.dao.mapper.ChinaCityMapper;
import com.vczyh.heweather.dao.mapper.CityMapper;
import com.vczyh.heweather.dao.mapper.DistrictMapper;
import com.vczyh.heweather.dao.mapper.ProvinceMapper;
import com.vczyh.heweather.domain.po.ChinaCity;
import com.vczyh.heweather.domain.po.City;
import com.vczyh.heweather.domain.po.District;
import com.vczyh.heweather.domain.po.Province;
import com.vczyh.heweather.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    ChinaCityMapper chinaCityMapper;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    DistrictMapper districtMapper;
    @Autowired
    ProvinceMapper provinceMapper;

    @Override
    public void test() {
        List<City> cityList = cityMapper.selectAll();
        for (City city : cityList) {
            System.out.println("=1 " + city.getCode());
            ChinaCity chinaCity = chinaCityMapper.selectByCityId(city.getCode());
            System.out.println("=2 " + chinaCity);
            Province province = provinceMapper.selectByName(chinaCity.getProvinceCn());
            System.out.println("=3 " + province.getId());
            city.setProvinceId(province.getId());
            cityMapper.updateByPrimaryKeySelective(city);
        }
    }

    @Override
    public void test2() {
        List<District> districtList = districtMapper.selectAll();
        for (District district : districtList) {
            ChinaCity chinaCity = chinaCityMapper.selectByCityId(district.getCode());
            City city = cityMapper.selectByName(chinaCity.getAdminDistrictCn());
            district.setCityId(city.getId());
            districtMapper.updateByPrimaryKeySelective(district);
        }

    }
}
