package com.vczyh.heweather.domain.po;

import lombok.Data;

@Data
public class ChinaCity {
    private Integer id;

    private String cityId;

    private String cityEn;

    private String cityCn;

    private String countryCode;

    private String countryEn;

    private String countryCn;

    private String provinceEn;

    private String provinceCn;

    private String adminDistrictEn;

    private String adminDistrictCn;

    private String latitude;

    private String longitude;

    private String adCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn == null ? null : cityEn.trim();
    }

    public String getCityCn() {
        return cityCn;
    }

    public void setCityCn(String cityCn) {
        this.cityCn = cityCn == null ? null : cityCn.trim();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn == null ? null : countryEn.trim();
    }

    public String getCountryCn() {
        return countryCn;
    }

    public void setCountryCn(String countryCn) {
        this.countryCn = countryCn == null ? null : countryCn.trim();
    }

    public String getProvinceEn() {
        return provinceEn;
    }

    public void setProvinceEn(String provinceEn) {
        this.provinceEn = provinceEn == null ? null : provinceEn.trim();
    }

    public String getProvinceCn() {
        return provinceCn;
    }

    public void setProvinceCn(String provinceCn) {
        this.provinceCn = provinceCn == null ? null : provinceCn.trim();
    }

    public String getAdminDistrictEn() {
        return adminDistrictEn;
    }

    public void setAdminDistrictEn(String adminDistrictEn) {
        this.adminDistrictEn = adminDistrictEn == null ? null : adminDistrictEn.trim();
    }

    public String getAdminDistrictCn() {
        return adminDistrictCn;
    }

    public void setAdminDistrictCn(String adminDistrictCn) {
        this.adminDistrictCn = adminDistrictCn == null ? null : adminDistrictCn.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode == null ? null : adCode.trim();
    }
}