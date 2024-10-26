package pl.com.itsystems.openweathermap;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Weather {
    private String name;
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private double pressure;
    private double humidity;
    private double seaLevel;
    private double grndLevel;
}
