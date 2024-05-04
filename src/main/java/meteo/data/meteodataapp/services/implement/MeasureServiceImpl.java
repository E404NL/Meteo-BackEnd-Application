package meteo.data.meteodataapp.services.implement;

import lombok.AllArgsConstructor;
import meteo.data.meteodataapp.dao.MeasureRepository;
import meteo.data.meteodataapp.models.Measure;
import meteo.data.meteodataapp.services.interfaces.MeasureService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
@AllArgsConstructor
public class MeasureServiceImpl implements MeasureService {
    private MeasureRepository measureRepository;

    @Override
    public Collection<Measure> findAll() {
        return measureRepository.findAll();
    }

    @Override
    public Measure findMeasureById(String id) {
        return measureRepository.findById(id).orElse(null);
    }

    @Override
    public Measure saveMeasure(Measure measure) {
        return measureRepository.save(measure);
    }

    @Override
    public void deleteMeasureByMeasureId(String id) {
        measureRepository.deleteById(id);
    }

    public Collection<Measure> findMeasuresByTimes(LocalDateTime startTime, LocalDateTime endTime){
        return measureRepository.findMeasuresByTimestampBetween(startTime, endTime);
    }
}
