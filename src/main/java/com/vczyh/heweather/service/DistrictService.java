package com.vczyh.heweather.service;

import com.vczyh.heweather.domain.po.District;

import java.util.List;

public interface DistrictService {

    List<District> getByCityId(int cityId);
}
