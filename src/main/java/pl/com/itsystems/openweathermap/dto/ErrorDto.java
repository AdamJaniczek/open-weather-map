package pl.com.itsystems.openweathermap.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDto {
    private int cod;
    private String message;
}
