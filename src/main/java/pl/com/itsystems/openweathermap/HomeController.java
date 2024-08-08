package pl.com.itsystems.openweathermap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final WeatherService weatherService;

    public HomeController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, @RequestParam String units, @RequestParam String lang, Model model) {
        Weather weather = WeatherDtoMapper.map(weatherService.getWeather(name, units, lang));
        model.addAttribute("weather", weather);
        return "home";
    }
}
