package com.vczyh.heweather.service.impl;

import com.vczyh.heweather.dao.mapper.ChinaCityMapper;
import com.vczyh.heweather.domain.vo.Province;
import com.vczyh.heweather.service.ChinaCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChinaCityServiceImpl implements ChinaCityService {

    @Autowired
    ChinaCityMapper chinaCityMapper;

    @Override
    public List<Province> getAllProvince() {
        return null;
    }
}
