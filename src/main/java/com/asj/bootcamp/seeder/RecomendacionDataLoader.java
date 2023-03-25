package com.asj.bootcamp.seeder;

import com.asj.bootcamp.entity.Recomendacion;
import com.asj.bootcamp.repository.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RecomendacionDataLoader implements CommandLineRunner {

    @Autowired
    RecomendacionRepository repository;


    @Override
    public void run(String... args) throws Exception {
        loadRecomendacionData();
    }

    private void loadRecomendacionData() {
        if (repository.count() == 0){
            Recomendacion recomendacion1 = new Recomendacion("Robin 'ropz' Kool", "zz z z a dawd ad a",  LocalDate.of(2022,4,23), "assets/cards/ropz.jpeg");
            Recomendacion recomendacion2 = new Recomendacion("Nikola 'NiKo' Kovač", "zz z z a dawd ad a",  LocalDate.of(2022,11,4), "assets/cards/niko.png");
            Recomendacion recomendacion3 = new Recomendacion("Keith 'NAF' Markovic", "zz z z a dawd ad a",  LocalDate.of(2023,1,15), "assets/cards/NAF.png");

            repository.save(recomendacion1);
            repository.save(recomendacion2);
            repository.save(recomendacion3);
        }
    }

}