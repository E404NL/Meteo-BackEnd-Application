package meteo.data.meteodataapp.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Meteo {
    private Float temperature;  // air temperature

    private Float humidityRate; // humidity rate

    private Long airPressure;   // air pressure

    @Override
    public String toString() {
        return "Meteo{" +
                "temperature=" + temperature +
                ", humidityRate=" + humidityRate +
                ", airPressure=" + airPressure +
                '}';
    }
}
