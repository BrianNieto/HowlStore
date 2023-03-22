package com.asj.bootcamp.service;

import com.asj.bootcamp.entity.Recomendacion;

public interface RecomendacionService {

    void createRecomendacion(Recomendacion recomendacion);

    Recomendacion getRecomendacion(Integer id);

    Recomendacion updateRecomendacion(Integer id, Recomendacion tmp);

    void deleteRecomendacion(Integer id);

}