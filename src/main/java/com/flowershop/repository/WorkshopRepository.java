package com.flowershop.repository;

import com.flowershop.entity.Product;
import com.flowershop.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, Integer>
{
    Workshop getWorkshopByProduct(Product product);
}
