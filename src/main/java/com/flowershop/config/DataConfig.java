package com.flowershop.config;

import com.flowershop.entity.Product;
import com.flowershop.entity.Workshop;
import com.flowershop.repository.ProductRepository;
import com.flowershop.repository.WorkshopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class DataConfig
{
    // Данные для инициализации базы данных питомцев
    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository, WorkshopRepository workshopRepository)
    {
        return (args) -> {
            if (productRepository.findAll().isEmpty())
            {
                var products = new ArrayList<Product>();
                // Для собак
                products.add(new Product("Душистая сирень", 1990, "bouquet"));
                products.add(new Product("Букет из 19 ирисов", 2190, "bouquet"));
                products.add(new Product("Букет Лидия", 2290, "bouquet"));
                products.add(new Product("Букет из 15 альстромерий с зеленью", 2490, "bouquet"));
                // Для кошек
                products.add(new Product("Кэнди", 1640, "bouquetInBox"));
                products.add(new Product("Сирень в коробке", 5090, "bouquetInBox"));
                products.add(new Product("Пионовидная кустовая роза в коробке", 3150, "bouquetInBox"));
                products.add(new Product("Звёздная ночь", 2950, "bouquetInBox"));
                // Для рыб
                products.add(new Product("Флорариум с сухоцветами Роуз", 4400, "driedFlower"));
                products.add(new Product("Лаванда", 1200, "driedFlower"));
                products.add(new Product("Лавандовый букет в крафте", 2650, "driedFlower"));
                products.add(new Product("Розовый букет из сухоцветов", 1100, "driedFlower"));
                // Для птиц
                products.add(new Product("Искусственные кустовые пионовидные розы", 500, "artificialFlower"));
                products.add(new Product("Искусственная композиция «Райские Орхидеи»", 42850, "artificialFlower"));
                products.add(new Product("Пионы, композиция из сухоцветов и искусственных цветов в деревянном кашпо", 5900, "artificialFlower"));
                products.add(new Product("Сиреневая композиция из сухоцветов и искусственных цветов", 3250, "artificialFlower"));
                productRepository.saveAll(products);

                for (var product : products)
                {
                    workshopRepository.save(new Workshop(product, 80));
                }
            }
        };
    }
}
