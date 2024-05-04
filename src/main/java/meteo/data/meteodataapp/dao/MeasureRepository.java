package meteo.data.meteodataapp.dao;

import meteo.data.meteodataapp.models.Measure;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MeasureRepository extends MongoRepository<Measure, Long> {
    public List<Measure> findMeasuresByTimestampBetween(LocalDateTime timeStart, LocalDateTime timeEnd);
    public Measure findMeasuresByMeasureID(String mesureID);
}
