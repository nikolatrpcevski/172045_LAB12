package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Order;

import java.util.Optional;

public interface OrderService {

    Order placeOrder(String balloonColor, String clientName, String address);

    Optional<Order> findById(Long id);

}
