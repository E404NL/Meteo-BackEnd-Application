package meteo.data.meteodataapp.controllers;

import meteo.data.meteodataapp.models.Measure;
import meteo.data.meteodataapp.services.implement.MeasureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

@RequestMapping("/measures")
@RestController
public class MeasureRestController {
    @Autowired
    private MeasureServiceImpl measureServiceImpl;
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping()
    public Measure createMeasure(@RequestBody Measure measure){
        return measureServiceImpl.saveMeasure(measure);
    }

    @GetMapping()
    public Collection<Measure> getAllMeasures(){
        return measureServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public Measure getMeasureById(@PathVariable String id){
        return measureServiceImpl.findMeasureById(id);
    }

    @GetMapping("/{startTime}/{endTime}")
    public Collection<Measure> getMeasureByTimes(@PathVariable String startTime,
                                                 @PathVariable String endTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTimeStart = LocalDateTime.parse(startTime, formatter);
        LocalDateTime dateTimeEnd = LocalDateTime.parse(endTime, formatter);
        var measures = measureServiceImpl.findMeasuresByTimes(dateTimeStart,dateTimeEnd);
        if(measures == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Measures not found\n");
        }
        return measures;
    }

    @GetMapping("/{thingID}/{startTime}/{endTime}")
    public Collection<Measure> getMeasuresByThingIdAndByTimes(@PathVariable String thingID,
                                                              @PathVariable String startTime,
                                                              @PathVariable String endTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTimeStart = LocalDateTime.parse(startTime, formatter);
        LocalDateTime dateTimeEnd = LocalDateTime.parse(endTime, formatter);
        var measures = measureServiceImpl.findMeasuresByThingIdAndByTimes(thingID, dateTimeStart, dateTimeEnd);
        if(measures == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Measures not found\n");
        }
        return measures;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteMeasureById(@PathVariable String id){
        var isExist = measureServiceImpl.findMeasureById(id);
        if (isExist != null) {
            measureServiceImpl.deleteMeasureByMeasureId(id);
            return true;
        }
        return false;
    }

    @DeleteMapping()
    public Boolean deleteAllMeasures(){
        long dataLength = measureServiceImpl.countAllMeasuresInDatabase();
        if(dataLength>0){
            measureServiceImpl.deleteAllMeasures();
            return true;
        }
        return false;
    }
}
