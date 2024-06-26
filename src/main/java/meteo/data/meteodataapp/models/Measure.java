package meteo.data.meteodataapp.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Measure {
    @Id
    private Long MeasureID; // measure ID

    private LocalDateTime timestamp;  // local time at the measure POST request

    private String thingID;     // embedded system ID what's post the request

    private Meteo meteo;    // meteo datas during the measure

    private Battery battery;    // battery state during the measure

    @Override
    public String toString() {
        return "Measure{" +
                "MeasureID='" + MeasureID + '\'' +
                ", timestamp=" + timestamp +
                ", thingID='" + thingID + '\'' +
                ", meteo=" + meteo +
                ", battery=" + battery +
                '}';
    }
}
