package com.example.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * https://openweathermap.org/current
 * The class is for getting data of weather
 */
public class weatherData {
    private String mTemperature, mcity,mWeatherType;
    private int mCondition;
    private String mHumidity;

    /**
     * The method for weatherData
     * @param jsonObject
     * @return weatherData of temperature, city name, and weather condition
     */
    public static weatherData fromJson(JSONObject jsonObject)
    {

        try
        {
            weatherData weatherD=new weatherData();
            weatherD.mcity=jsonObject.getString("name");

            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");

            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mTemperature=Integer.toString(roundedValue);

            // TODO DATE AND TIME
            // TODO HUMIDITY

            return weatherD;
        }

        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Getting temperature
     * @return temperature in String
     */
    public String getmTemperature() {
        return mTemperature+"°C";
    }

    /**
     * Getting City name
     * @return city name in String
     */
    public String getMcity() {
        return mcity;
    }

    /**
     * Getting weather type
     * @return weather type in String
     */
    public String getmWeatherType() {
        return mWeatherType;
    }

}
