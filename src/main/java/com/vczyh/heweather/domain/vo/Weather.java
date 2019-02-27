package com.vczyh.heweather.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vczyh.heweather.domain.po.AirQuality;
import com.vczyh.heweather.domain.po.DailyForecast;
import com.vczyh.heweather.domain.po.WeatherLive;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonProperty("HeWeather")
    private List<HeWeatherBean> heWeather;

    public Weather(WeatherLive weatherLive, AirQuality airQuality, DailyForecast dailyForecast) {
        WeatherLive.HeWeather6Bean weather = weatherLive.getHeWeather6().get(0);
        AirQuality.HeWeather6Bean air = airQuality.getHeWeather().get(0);
        DailyForecast.HeWeather6Bean forecast = dailyForecast.getHeWeather6().get(0);
        heWeather = new ArrayList<>();
        heWeather.add(new HeWeatherBean(weather, air, forecast));
    }

    public List<HeWeatherBean> getHeWeather() {
        return heWeather;
    }

    public void setHeWeather(List<HeWeatherBean> heWeather) {
        this.heWeather = heWeather;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class HeWeatherBean {
        /**
         * aqi : {"city":{"aqi":"44","pm25":"13"}}
         * basic : {"city":"苏州","id":"CN101190401","update":{"loc":"2016-08-08 21:58"}}
         * daily_forecast : [{"cond":{"txt_d":"阵雨"},"date":"2016-08-08","tmp":{"max":"34","min":"27"}}]
         * now : {"cond":{"txt":"降雨"},"tmp":"29"}
         * status : ok
         * suggestion : {"comf":{"txt":"舒适度建议"},"cw":{"txt":"汽车出行建议"},"sport":{"txt":"运动建议"}}
         */

        private AqiBean aqi;
        private BasicBean basic;
        private NowBean now;
        private String status;
        private SuggestionBean suggestion;
        private List<DailyForecastBean> daily_forecast;

        public HeWeatherBean(WeatherLive.HeWeather6Bean weather, AirQuality.HeWeather6Bean air, DailyForecast.HeWeather6Bean forecast) {
            setAqi(new AqiBean(weather, air));
            setBasic(new BasicBean(weather));
            setNow(new NowBean(weather, air));
            setStatus("ok");
            String weatherStatus = weather.getStatus();
            String airStatus = air.getStatus();
            if (!weatherStatus.equals("ok")) {
                setStatus(weatherStatus);
            }
            if (!airStatus.equals("ok")) {
                setStatus(airStatus);
            }
            daily_forecast = new ArrayList<>();
            for (DailyForecast.HeWeather6Bean.DailyForecastBean dailyForecastBean : forecast.getDaily_forecast()) {
                daily_forecast.add(new DailyForecastBean(dailyForecastBean));
            }

        }

        public AqiBean getAqi() {
            return aqi;
        }

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionBean getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionBean suggestion) {
            this.suggestion = suggestion;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AqiBean {
            /**
             * city : {"aqi":"44","pm25":"13"}
             */

            private CityBean city;

            public AqiBean(WeatherLive.HeWeather6Bean weather, AirQuality.HeWeather6Bean air) {
                city = new CityBean(weather, air);
            }

            public CityBean getCity() {
                return city;
            }

            public void setCity(CityBean city) {
                this.city = city;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CityBean {
                /**
                 * aqi : 44
                 * pm25 : 13
                 */

                private String aqi;
                private String pm25;

                public CityBean(WeatherLive.HeWeather6Bean weather6Bean, AirQuality.HeWeather6Bean air) {
                    setAqi(air.getAir_now_city().getAqi());
                    setPm25(air.getAir_now_city().getPm25());
                }

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }
            }
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class BasicBean {
            /**
             * city : 苏州
             * id : CN101190401
             * update : {"loc":"2016-08-08 21:58"}
             */

            private String city;
            private String id;
            private UpdateBean update;

            public BasicBean(WeatherLive.HeWeather6Bean heWeather6Bean) {
                setCity(heWeather6Bean.getBasic().getLocation());
                setId(heWeather6Bean.getBasic().getCid());
                update = new UpdateBean(heWeather6Bean);
            }

//            public String getCity() {
//                return city;
//            }

//            public void setCity(String city) {
//                this.city = city;
//            }

//            public String getId() {
//                return id;
//            }
//
//            public void setId(String id) {
//                this.id = id;
//            }
//
//            public UpdateBean getUpdate() {
//                return update;
//            }
//
//            public void setUpdate(UpdateBean update) {
//                this.update = update;
//            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UpdateBean {
                /**
                 * loc : 2016-08-08 21:58
                 */

                private String loc;

                public UpdateBean(WeatherLive.HeWeather6Bean heWeather6Bean) {
                    setLoc(heWeather6Bean.getUpdate().getLoc());
                }

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class NowBean {
            /**
             * cond : {"txt":"降雨"}
             * tmp : 29
             */

            private CondBean cond;
            private String tmp;

            public NowBean(WeatherLive.HeWeather6Bean weather, AirQuality.HeWeather6Bean air) {
                setCond(new CondBean(weather, air));
                setTmp(weather.getNow().getTmp());
            }

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CondBean {
                /**
                 * txt : 降雨
                 */

                private String txt;

                public CondBean(WeatherLive.HeWeather6Bean weather, AirQuality.HeWeather6Bean air) {
                    setTxt(weather.getNow().getCond_txt());
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SuggestionBean {
            /**
             * comf : {"txt":"舒适度建议"}
             * cw : {"txt":"汽车出行建议"}
             * sport : {"txt":"运动建议"}
             */

            private ComfBean comf;
            private CwBean cw;
            private SportBean sport;

            public ComfBean getComf() {
                return comf;
            }

            public void setComf(ComfBean comf) {
                this.comf = comf;
            }

            public CwBean getCw() {
                return cw;
            }

            public void setCw(CwBean cw) {
                this.cw = cw;
            }

            public SportBean getSport() {
                return sport;
            }

            public void setSport(SportBean sport) {
                this.sport = sport;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ComfBean {
                /**
                 * txt : 舒适度建议
                 */

                private String txt;

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CwBean {
                /**
                 * txt : 汽车出行建议
                 */

                private String txt;

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SportBean {
                /**
                 * txt : 运动建议
                 */

                private String txt;

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DailyForecastBean {
            /**
             * cond : {"txt_d":"阵雨"}
             * date : 2016-08-08
             * tmp : {"max":"34","min":"27"}
             */

            private CondBeanX cond;
            private String date;
            private TmpBean tmp;

            public DailyForecastBean(DailyForecast.HeWeather6Bean.DailyForecastBean dailyForecastBean) {
                setCond(new CondBeanX(dailyForecastBean));
                setDate(dailyForecastBean.getDate());
                setTmp(new TmpBean(dailyForecastBean));
            }

            public CondBeanX getCond() {
                return cond;
            }

            public void setCond(CondBeanX cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CondBeanX {
                /**
                 * txt_d : 阵雨
                 */

                private String txt_d;

                public CondBeanX(DailyForecast.HeWeather6Bean.DailyForecastBean dailyForecastBean) {
                    setTxt_d(dailyForecastBean.getCond_txt_d());
                }

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class TmpBean {
                /**
                 * max : 34
                 * min : 27
                 */

                private String max;
                private String min;

                public TmpBean(DailyForecast.HeWeather6Bean.DailyForecastBean dailyForecastBean) {
                    setMax(dailyForecastBean.getTmp_max());
                    setMin(dailyForecastBean.getTmp_min());
                }

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }
        }
    }
}
