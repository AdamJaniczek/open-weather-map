package pl.com.itsystems.openweathermap;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.itsystems.openweathermap.exception.CityNotFoundException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(CityNotFoundException.class)
    public String handleCityNotFoundException(Model model, CityNotFoundException e) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(Model model, RuntimeException e) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
