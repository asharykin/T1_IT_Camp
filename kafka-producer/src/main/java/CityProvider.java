import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CityProvider {
    private final Random random;
    private final List<String> cities;

    public CityProvider() {
        this.random = new Random();
        this.cities = List.of(
                "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань",
                "Нижний Новгород", "Челябинск", "Самара", "Омск", "Ростов-на-Дону",
                "Уфа", "Красноярск", "Воронеж", "Пермь", "Волгоград"
        );
    }

    public String getRandomCity() {
        return cities.get(random.nextInt(cities.size()));
    }
}
