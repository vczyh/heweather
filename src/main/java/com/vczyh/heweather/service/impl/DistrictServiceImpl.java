package com.vczyh.heweather.service.impl;

import com.vczyh.heweather.dao.mapper.DistrictMapper;
import com.vczyh.heweather.domain.po.District;
import com.vczyh.heweather.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictMapper districtMapper;


    @Override
    public List<District> getByCityId(int cityId) {
        return districtMapper.selectByCityId(cityId);
    }
}
