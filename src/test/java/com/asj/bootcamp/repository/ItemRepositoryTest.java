package com.asj.bootcamp.repository;

import com.asj.bootcamp.datos.DatosDummy;
import com.asj.bootcamp.entity.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @BeforeEach
    void setUp() {
        repository.save(DatosDummy.getItem());
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void findByNombreItemAndEstadoItem() {
        Optional<Item> optionalItem = this.repository.findByNombreItemAndEstadoItem("M9 Bayonet | Tiger Tooth","Factory New");

        assertThat(optionalItem.isPresent()).isTrue();
        assertThat(optionalItem.get().getNombreItem()).isEqualTo("M9 Bayonet | Tiger Tooth");
        assertThat(optionalItem.get().getEstadoItem()).isEqualTo("Factory New");
    }

}