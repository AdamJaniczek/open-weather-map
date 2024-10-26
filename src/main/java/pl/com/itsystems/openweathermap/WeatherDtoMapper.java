package pl.com.itsystems.openweathermap;

import pl.com.itsystems.openweathermap.dto.WeatherResponseDto;

public class WeatherDtoMapper {
    static Weather map(WeatherResponseDto weatherResponseDto) {
        return new Weather(
                weatherResponseDto.getName(),
                weatherResponseDto.getMain().get("temp"),
                weatherResponseDto.getMain().get("feels_like"),
                weatherResponseDto.getMain().get("temp_min"),
                weatherResponseDto.getMain().get("temp_max"),
                weatherResponseDto.getMain().get("pressure"),
                weatherResponseDto.getMain().get("humidity"),
                weatherResponseDto.getMain().get("sea_level"),
                weatherResponseDto.getMain().get("grnd_level")
                );
    }
}
