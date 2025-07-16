import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Random;

@Getter
public enum WeatherCondition {
    SUNNY("солнечно"),
    CLOUDY("облачно"),
    RAINY("дождь");

    private static final Random random = new Random();

    @JsonValue
    private final String ruName;

    WeatherCondition(String ruName) {
        this.ruName = ruName;
    }

    public static WeatherCondition getRandomCondition() {
        WeatherCondition[] values = WeatherCondition.values();
        return values[random.nextInt(values.length)];
    }
}
