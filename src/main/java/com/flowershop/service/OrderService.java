package com.flowershop.service;

import com.flowershop.entity.CartItem;
import com.flowershop.entity.Order;
import com.flowershop.entity.Product;
import com.flowershop.repository.OrderRepository;
import com.flowershop.repository.ProductRepository;
import com.flowershop.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WorkshopRepository workshopRepository;
    @Autowired
    private UserService userService;

    public boolean addOrder(List<CartItem> items, String name)
    {
        try {
            var order = new Order();
            order.setOrderNum(getOrderNum());
            order.setUser(userService.getUserByName(name));
            order.setProducts(getProductList(items));
            orderRepository.save(order);
            userService.addOrder(order, name);

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    private List<Product> getProductList(List<CartItem> items)
    {
        var products = new ArrayList<Product>();
        for (var item : items)
        {
            var product = productRepository.getProductsByTitle(item.getProductName());
            products.add(product);

            var workshop = workshopRepository.getWorkshopByProduct(product);
            workshop.decreaseCount(item.getQuantity());
            workshopRepository.save(workshop);
        }

        return products;
    }

    private int getOrderNum()
    {
        var random = new Random();
        return random.nextInt(99999 - 10000 + 1) + 10000;
    }
}
