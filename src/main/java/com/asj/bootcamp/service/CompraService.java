package com.asj.bootcamp.service;

import com.asj.bootcamp.dto.CompraDTO;
import com.asj.bootcamp.entity.Compra;
import com.asj.bootcamp.exception.NotFoundException;

public interface CompraService {

    Compra createCompra(Compra compra);

    Compra getCompra(Integer id);

    Compra updateCompra(Integer id, Compra tmp);

    void deleteCompra(Integer id);
}