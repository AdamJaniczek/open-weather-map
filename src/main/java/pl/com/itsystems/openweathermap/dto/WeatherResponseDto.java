package pl.com.itsystems.openweathermap.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDto {
    private Map<String, Double> main;
    private String name;
}
