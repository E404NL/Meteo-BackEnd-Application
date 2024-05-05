package meteo.data.meteodataapp.services.interfaces;

import meteo.data.meteodataapp.models.Measure;

import java.time.LocalDateTime;
import java.util.Collection;

public interface MeasureService {
    public Collection<Measure> findAll();
    public Measure findMeasureById(String id);
    public Measure saveMeasure(Measure measure);
    public void deleteMeasureByMeasureId(String id);
}
