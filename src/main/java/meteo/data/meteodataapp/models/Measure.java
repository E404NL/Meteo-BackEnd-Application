package meteo.data.meteodataapp.models;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String id; // measure ID

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;  // local time at the measure POST request

    private String thingID;     // embedded system ID what's post the request

    private Meteo meteo;    // meteo datas during the measure

    private Battery battery;    // battery state during the measure

    public Measure(LocalDateTime now, String s, Meteo meteo, Battery battery) {
        this.timestamp = now;
        this.thingID = s;
        this.meteo = meteo;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "MeasureID='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", thingID='" + thingID + '\'' +
                ", meteo=" + meteo +
                ", battery=" + battery +
                '}';
    }
}
