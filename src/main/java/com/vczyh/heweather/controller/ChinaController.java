package com.vczyh.heweather.controller;

import com.vczyh.heweather.service.CityService;
import com.vczyh.heweather.service.DistrictService;
import com.vczyh.heweather.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "china")
public class ChinaController {

    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @Autowired
    private DistrictService districtService;

    @GetMapping(value = "")
    public Object getAllProvince() {
        return provinceService.getAll();
    }

    @GetMapping(value = "{provinceId}")
    public Object getByProvinceId(@PathVariable("provinceId") int provinceId) {
        return cityService.getByProvinceId(provinceId);
    }

    @GetMapping(value = "{provinceId}/{cityId}")
    public Object get(@PathVariable("cityId") int cityId) {
        return districtService.getByCityId(cityId);
    }

}
