package com.asj.bootcamp.seeder;

import com.asj.bootcamp.entity.Category;
import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.repository.CategoryRepository;
import com.asj.bootcamp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemDataLoader implements CommandLineRunner {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadItemData();
    }

    private void loadItemData() {
        if (itemRepository.count() == 0){
            Category pistolas = categoryRepository.findByNombreCategoria("Pistolas").get();
            Category smg = categoryRepository.findByNombreCategoria("SMG").get();
            Category rifles = categoryRepository.findByNombreCategoria("Rifles").get();


            Item item1 = new Item("AK-47 | Leet Museo", 45000, 4,"Minimal Wear","assets/tienda/ak-47 leet museo(minimal wear)/1.png", "assets/tienda/ak-47 leet museo(minimal wear)/2.jpg", "assets/tienda/ak-47 leet museo(minimal wear)/3.jpg", rifles);
            Item item2 = new Item("Glock-18 | Gamma Doppler", 25000, 2,"Factory New","assets/tienda/glock-18 gamma doppler(factory new)/1.png", "assets/tienda/glock-18 gamma doppler(factory new)/2.jpg", "assets/tienda/glock-18 gamma doppler(factory new)/3.jpg", pistolas);
            Item item3 = new Item("AWP | Desert Hydra", 400000, 1,"Factory New","assets/tienda/awp desert hydra (factory new)/1.png", "assets/tienda/awp desert hydra (factory new)/2.jpg", "assets/tienda/awp desert hydra (factory new)/3.jpg", rifles);
            Item item4 = new Item("USP-S | Purple DDPAT", 5000, 7,"Factory New","assets/tienda/usp-s purple ddpat (factory new)/1.png", "assets/tienda/usp-s purple ddpat (factory new)/2.jpg", "assets/tienda/usp-s purple ddpat (factory new)/3.jpg", pistolas);
            Item item5 = new Item("SG553 | Hazard Pay", 300000, 3,"Factory New","assets/tienda/sg553 hazard pay (factory new)/1.png", "assets/tienda/sg553 hazard pay (factory new)/2.jpg", "assets/tienda/sg553 hazard pay (factory new)/3.jpg", rifles);

            itemRepository.save(item1);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);

        }
    }

}