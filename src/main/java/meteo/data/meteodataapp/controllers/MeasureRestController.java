package meteo.data.meteodataapp.controllers;

import meteo.data.meteodataapp.dao.MeasureRepository;
import meteo.data.meteodataapp.models.Measure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MeasureRestController {
    private MeasureRepository measureRepository;
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping()
    public Measure createMeasure(@RequestBody Measure measure){
        return measureRepository.save(measure);
    }

    @GetMapping()
    public List<Measure> getAllMeasures(){
        return measureRepository.findAll();
    }

    @GetMapping("/{id}")
    public Measure getMeasureById(String id){
        return measureRepository.findMeasuresByMeasureID(id);
    }

    @GetMapping("/{startTime}/{endTime}")
    public List<Measure> getMeasureByTimes(@PathVariable LocalDateTime startTime,@PathVariable LocalDateTime endTime){
        var measures = measureRepository.findMeasuresByTimestampBetween(startTime,endTime);
        if(measures == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Measures not found\n");
        }
        return measures;
    }


}
