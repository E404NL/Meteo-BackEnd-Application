package meteo.data.meteodataapp.controllers;

import meteo.data.meteodataapp.dao.MeasureRepository;
import meteo.data.meteodataapp.models.Measure;
import meteo.data.meteodataapp.services.implement.MeasureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

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
    public Collection<Measure> getMeasureByTimes(@PathVariable LocalDateTime startTime,@PathVariable LocalDateTime endTime){
        var measures = measureServiceImpl.findMeasuresByTimes(startTime,endTime);
        if(measures == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Measures not found\n");
        }
        return measures;
    }


}
