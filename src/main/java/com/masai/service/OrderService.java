package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.model.Orders;

@Service
public interface OrderService {
	Orders addOrder(Orders order);
	Orders updateOrder(Orders order);
	Orders deleteOrder(int orderId);
	Orders viewOrder(int orderId);
	List<Orders>viewAllOrders();
	
	
}
