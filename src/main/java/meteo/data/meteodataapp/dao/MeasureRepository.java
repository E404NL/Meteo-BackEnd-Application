package meteo.data.meteodataapp.dao;

import meteo.data.meteodataapp.models.Measure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeasureRepository extends MongoRepository<Measure, Long> {

}
