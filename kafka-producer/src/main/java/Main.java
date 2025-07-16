public class Main {
    public static final String BROKERS = "localhost:9092";
    public static final String TOPIC = "weather-topic";

    public static void main(String[] args) throws Exception {
        try (WeatherProducer producer = new WeatherProducer(BROKERS, TOPIC)) {
            while (true) {
                producer.sendWeatherMessage();
                Thread.sleep(2000);
            }
        }
    }
}
