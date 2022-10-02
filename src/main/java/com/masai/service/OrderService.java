package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.model.OrderDTO;
import com.masai.model.OrderDTO2;
import com.masai.model.Orders;
import com.masai.model.SignUpData;

@Service
public interface OrderService {
	public OrderDTO2 addOrder(OrderDTO order) throws OrderException;
	public Orders updateOrder(Orders order) throws OrderException;
	public Orders deleteOrder(Integer orderId) throws OrderException;
	public Orders viewOrder(Integer orderId) throws OrderException;
	public List<Orders>viewAllOrders() throws OrderException;
	public SignUpData viewcustomer(Integer orderid) throws OrderException;
	
	public List<Orders> viewordersbyuserid(Integer userid)throws OrderException;
	
	
	
}
