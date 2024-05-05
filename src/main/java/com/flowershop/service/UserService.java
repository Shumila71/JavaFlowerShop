package com.flowershop.service;

import com.flowershop.entity.Order;
import com.flowershop.entity.User;
import com.flowershop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User getUserByName(String userName)
    {
        return userRepository.getUserByName(userName);
    }

    public void addOrder(Order order, String name)
    {
        var user = getUserByName(name);
        user.getOrders().add(order);
        userRepository.save(user);
    }
}
