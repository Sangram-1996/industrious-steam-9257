package com.masai.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Orders;
import com.masai.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repository;

	
	//	Adding Order
	
	@Override
	public Orders addOrder(Orders order) {
		// TODO Auto-generated method stub
		
		return repository.save(order);
	}

	
	// Updating Order	
	@Override
	public Orders updateOrder(Orders order) {
		// TODO Auto-generated method stub
		Orders od= repository.findById(order.getOrderId()).orElseThrow(()-> new EntityNotFoundException("Currently no Order available with this orderId"));
		od.setQuantity(order.getQuantity());
		return repository.save(od);
	}

	@Override
	public Orders deleteOrder(int orderId) {
		// TODO Auto-generated method stub
			Orders od=repository.findById(orderId).orElseThrow(()->new EntityNotFoundException("Currently no Order available with this orderId"));
			repository.deleteById(orderId);
			return od;
	}

	@Override
	public Orders viewOrder(int orderId) {
		// TODO Auto-generated method stub
		Orders od=repository.findById(orderId).orElseThrow(()->new EntityNotFoundException("Currently no Order available with this orderId"));
		return od;
	}

	@Override
	public List<Orders> viewAllOrders() {
		// TODO Auto-generated method stub
		List<Orders>od= repository.findAll();
		if(od.isEmpty()) {
			throw new NullPointerException("Currently no Order available with this orderId");
		}
		
		return od;
	}

	
}
