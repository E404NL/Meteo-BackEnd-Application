package meteo.data.meteodataapp;

import lombok.AllArgsConstructor;
import meteo.data.meteodataapp.dao.MeasureRepository;
import meteo.data.meteodataapp.models.Battery;
import meteo.data.meteodataapp.models.Measure;
import meteo.data.meteodataapp.models.Meteo;
import meteo.data.meteodataapp.services.implement.MeasureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@AllArgsConstructor
public class MeteoDataAppApplication implements CommandLineRunner {

    @Autowired
    private MeasureRepository measureRepository;

    @Autowired
    private MeasureServiceImpl measureServiceImpl;
    public static void main(String[] args) {
        SpringApplication.run(MeteoDataAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        measureRepository.deleteAll();

        measureServiceImpl.saveMeasure(new Measure(
                LocalDateTime.now(),
                "ESP8266-1",
                new Meteo(23.59f, 10.78f, 115000l),
                new Battery(45, 5.4f)
        ));

        System.out.println("Measures found with findMeasuresByMeasureID():");
        System.out.println("---------------------------------------------");
        for(Measure measure : measureServiceImpl.findAll()){
            System.out.println(measure);
        }
    }
}
