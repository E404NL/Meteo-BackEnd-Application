package meteo.data.meteodataapp.dao;

import meteo.data.meteodataapp.models.Measure;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Collection;

public interface MeasureRepository extends MongoRepository<Measure, String> {
    public Collection<Measure> findMeasuresByTimestampBetween(LocalDateTime timeStart, LocalDateTime timeEnd);
    public Collection<Measure> findMeasuresByThingIDAndTimestampBetween(String thingID, LocalDateTime startTime, LocalDateTime endTime);
    public long countBy();
}
