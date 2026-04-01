
import java.util.Arrays;
import java.util.List;

public class IoTSensorReadings {

    public static void main(String[] args) {

        List<Double> readings = Arrays.asList(
                21.5,
                27.3,
                30.1,
                18.9,
                29.7
        );

        double threshold = 25.0;

        // Use streams with forEach() to print readings above threshold
        readings.stream()
                .filter(value -> value > threshold)
                .forEach(value
                        -> System.out.println("Alert: Sensor reading above threshold -> " + value)
                );
    }
}
