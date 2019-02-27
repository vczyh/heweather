package com.vczyh.heweather.service;

import com.vczyh.heweather.domain.po.City;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;

import java.util.List;

public interface CityService {

    List<City> getByProvinceId(int provinceId);
}
