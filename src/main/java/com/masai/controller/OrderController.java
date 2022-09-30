package com.masai.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.masai.model.Orders;
import com.masai.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	// Adding order
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Orders> addOrder(@Valid @RequestBody Orders order){
		Orders od=orderService.addOrder(order);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(od.getOrderId()).toUri(); 
		return ResponseEntity.created(location).body(od);
		
	}
	
	//Updating Order
	@PostMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Orders>updateOrder(@RequestBody Orders order){
		Orders od=orderService.updateOrder(order);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(od.getOrderId()).toUri();
		return ResponseEntity.created(location).body(od);
	}
	
	//Deleting Order
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String>deleteOrder(@RequestBody Orders order){
		Orders od=orderService.deleteOrder(order.getOrderId());
		if(od!=null) {
			return new ResponseEntity<String>("Deleted Succesfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Please check order id is registered",HttpStatus.BAD_REQUEST);
		}
	}
	
	//	View All Orders
	public List<Orders>viewAllOrders(){
		return orderService.viewAllOrders();
		
	}
	
	//	View Order By ID
	
	public ResponseEntity<Orders>viewOrder(@PathVariable ("orderId")int orderId){
		Orders od=orderService.viewOrder(orderId);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(od.getOrderId()).toUri();
		
		return ResponseEntity.created(location).body(od);
		
	}
	
}
