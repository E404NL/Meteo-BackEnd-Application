package meteo.data.meteodataapp;

import meteo.data.meteodataapp.dao.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    }
}
