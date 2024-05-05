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
import java.util.Random;

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
        //measureRepository.deleteAll();
        Random random = new Random();

        // For create randoms fake datas on DB between every restart for testing later
        /*measureServiceImpl.saveMeasure(new Measure(
                LocalDateTime.now(),
                "ESP8266-1",
                new Meteo(random.nextFloat(-20f,50f),
                        random.nextFloat(0f,90f),
                        random.nextLong(105000l,110000l)),
                new Battery(random.nextInt(0,100),
                        random.nextFloat(1.0f,3.7f))
        ));*/

        System.out.println("Measures found with findMeasuresByMeasureID():");
        System.out.println("---------------------------------------------");
        for(Measure measure : measureServiceImpl.findAll()){
            System.out.println(measure);
        }
    }
}
