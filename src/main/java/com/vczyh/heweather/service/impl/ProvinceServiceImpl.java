package com.vczyh.heweather.service.impl;

import com.vczyh.heweather.dao.mapper.ProvinceMapper;
import com.vczyh.heweather.domain.po.Province;
import com.vczyh.heweather.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceMapper provinceMapper;

    @Override
    public List<Province> getAll() {
        return provinceMapper.selectAll();
    }
}
