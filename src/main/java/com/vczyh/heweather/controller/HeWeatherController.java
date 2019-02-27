package com.vczyh.heweather.controller;

import com.vczyh.heweather.domain.po.AirQuality;
import com.vczyh.heweather.domain.po.DailyForecast;
import com.vczyh.heweather.domain.po.WeatherLive;
import com.vczyh.heweather.domain.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "weather")
public class HeWeatherController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "")
    public Object weather() {
        // 实况天气
        String weatherURL = "https://free-api.heweather.net/s6/weather/now?location={1}&key={2}";
        String location = "CN101010100";
        String key = "c563f538a5734791850bc3fc6f0dfa5d";
        WeatherLive weatherLive = restTemplate
                .getForObject(weatherURL, WeatherLive.class, location, key);
        // 空气质量实况
        String airURL = "https://free-api.heweather.net/s6/air/now?location={1}&key={2}";
        AirQuality airQuality = restTemplate
                .getForObject(airURL, AirQuality.class, location, key);
        // 天气预测
        String forecastURL = "https://free-api.heweather.net/s6/weather/forecast?location={1}&key={2}";
        DailyForecast dailyForecast = restTemplate
                .getForObject(forecastURL, DailyForecast.class, location, key);

        Weather weather = new Weather(weatherLive, airQuality, dailyForecast);
        return weather;
    }

}
