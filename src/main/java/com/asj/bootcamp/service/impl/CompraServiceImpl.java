package com.asj.bootcamp.service.impl;

import com.asj.bootcamp.entity.Compra;
import com.asj.bootcamp.exception.NotFoundException;
import com.asj.bootcamp.repository.CompraRepository;
import com.asj.bootcamp.service.CompraService;

import java.util.Optional;

public class CompraServiceImpl implements CompraService {

    CompraRepository repository;

    @Override
    public Compra createCompra(Compra compra) {
        return repository.save(compra);
    }

    @Override
    public Compra getCompra(Integer id) throws NotFoundException {
        Optional<Compra> optionalCompra = repository.findById(id);
        if (optionalCompra.isPresent()) {
            return optionalCompra.get();
        }
        else {
            throw new RuntimeException("Compra con id " + id + " no existe");
        }

    }

    @Override
    public Compra updateCompra(Integer id, Compra tmp) {
        Compra compraUpdated;
        Optional<Compra> optionalCompra = repository.findById(id);
        if (optionalCompra.isPresent()){
            compraUpdated = optionalCompra.get();
        }
        else {
            throw new RuntimeException("Compra con id " + id + " no existe");
        }
        compraUpdated.setComentario(tmp.getComentario());
        compraUpdated.setEstadoPedido(tmp.getEstadoPedido());

        return repository.save(compraUpdated);
    }

    @Override
    public void deleteCompra(Integer id) {
        Optional<Compra> optionalCompra = repository.findById(id);
        if (optionalCompra.isPresent()) {
            repository.deleteById(id);
        }
        else {
            throw new RuntimeException("Compra con id " + id + " no existe");
        }
    }

}