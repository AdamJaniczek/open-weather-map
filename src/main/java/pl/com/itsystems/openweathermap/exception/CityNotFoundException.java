package pl.com.itsystems.openweathermap.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(String city) {
        super("Nie znaleziono miasta: " + city);
    }
}
