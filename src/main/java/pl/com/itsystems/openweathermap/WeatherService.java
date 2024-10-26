package pl.com.itsystems.openweathermap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.com.itsystems.openweathermap.dto.ErrorDto;
import pl.com.itsystems.openweathermap.dto.WeatherResponseDto;
import pl.com.itsystems.openweathermap.exception.CityNotFoundException;
import pl.com.itsystems.openweathermap.exception.InvalidApiKeyException;

import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {

    @Value("${appid}")
    private String apiKey;

    public WeatherResponseDto getWeather(String city, String units, String lang) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String url = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org")
                    .path("/data/2.5/weather")
                    .queryParam("q", city)
                    .queryParam("appid", apiKey)
                    .queryParam("units", units)
                    .queryParam("lang", lang)
                    .encode(StandardCharsets.ISO_8859_1)
                    .toUriString();
            return restTemplate.getForObject(url, WeatherResponseDto.class);
        } catch (HttpClientErrorException e) {
            final String errorMessage = e.getResponseBodyAsString();
            ObjectMapper mapper = new ObjectMapper();
            final ErrorDto errorDto;
            try {
                errorDto = mapper.readValue(errorMessage, ErrorDto.class);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException();
            }
            if (errorDto.getCod() == 401) {
                throw new InvalidApiKeyException(errorDto.getMessage());
            } else {
                throw new CityNotFoundException(city);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
