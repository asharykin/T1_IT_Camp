import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.util.Properties;
import java.util.Random;

public class WeatherProducer implements Closeable {
    private final String topic;
    private final KafkaProducer<String, String> producer;
    private final ObjectMapper objectMapper;
    private final CityProvider cityProvider;

    public WeatherProducer(String brokers, String topic) {
        this.topic = topic;
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.producer = new KafkaProducer<>(props);
        this.objectMapper = new ObjectMapper();
        this.cityProvider = new CityProvider();
    }

    public WeatherDto generateWeatherData() {
        String city = cityProvider.getRandomCity();
        int temperature = new Random().nextInt(36);
        WeatherCondition condition = WeatherCondition.getRandomCondition();
        return new WeatherDto(city, temperature, condition);
    }

    public void sendWeatherMessage() throws Exception {
        WeatherDto weatherDto = generateWeatherData();
        String weatherJson = objectMapper.writeValueAsString(weatherDto);
        producer.send(new ProducerRecord<>(topic, weatherJson)).get();
    }

    @Override
    public void close() {
        producer.close();
    }
}