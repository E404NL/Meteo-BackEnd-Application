package meteo.data.meteodataapp.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Battery {
    private Integer batteryState;   // percentage of energy available on the capacity

    private Float outputVoltage;    // output voltage from the battery

    @Override
    public String toString() {
        return "Battery{" +
                "batteryState=" + batteryState +
                ", outputVoltage=" + outputVoltage +
                '}';
    }
}
