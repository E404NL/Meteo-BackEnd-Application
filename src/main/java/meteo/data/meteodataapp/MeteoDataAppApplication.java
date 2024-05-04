package meteo.data.meteodataapp;

import meteo.data.meteodataapp.dao.MeasureRepository;
import meteo.data.meteodataapp.models.Battery;
import meteo.data.meteodataapp.models.Measure;
import meteo.data.meteodataapp.models.Meteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class MeteoDataAppApplication implements CommandLineRunner {

    @Autowired
    private MeasureRepository measureRepository;

    public static void main(String[] args) {
        SpringApplication.run(MeteoDataAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        measureRepository.deleteAll();

        measureRepository.save(new Measure(
                LocalDateTime.now(),
                "ESP8266-1",
                new Meteo(23.59f, 10.78f, 115000l),
                new Battery(45, 5.4f)
        ));

        System.out.println("Measures found with findMeasuresByMeasureID():");
        System.out.println("---------------------------------------------");
        for(Measure measure : measureRepository.findAll()){
            System.out.println(measure);
        }
    }
}
