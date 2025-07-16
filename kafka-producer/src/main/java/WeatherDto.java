import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WeatherDto {
    private String city;
    private int temperature;
    private WeatherCondition condition;
}
