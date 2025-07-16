public class Main {
    public static final String BROKERS = "localhost:9092";
    public static final String TOPIC = "weather-topic";
    public static final String GROUP_ID = "weather-consumer-group";

    public static void main(String[] args) {
        try (WeatherConsumer weatherConsumer = new WeatherConsumer(BROKERS, TOPIC, GROUP_ID)) {
            weatherConsumer.consumeMessages();
        }
    }
}
