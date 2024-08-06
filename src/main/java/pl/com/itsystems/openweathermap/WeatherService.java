package pl.com.itsystems.openweathermap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.com.itsystems.openweathermap.dto.WeatherResponseDto;
import pl.com.itsystems.openweathermap.exception.CityNotFoundException;

@Service
public class WeatherService {

    @Value("${appid}")
    private String apiKey;

    public WeatherResponseDto getWeather(String city, String units) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String url = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org")
                    .path("/data/2.5/weather")
                    .queryParam("q", city)
                    .queryParam("appid", apiKey)
                    .queryParam("units", units)
                    .queryParam("lang", "pl")
                    .toUriString();
            return restTemplate.getForObject(url, WeatherResponseDto.class);
        } catch (HttpClientErrorException e) {
            throw new CityNotFoundException(city);
        }
    }
}
