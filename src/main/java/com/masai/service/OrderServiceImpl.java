package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Orders;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;
import com.masai.model.SignUpData;
import com.masai.repository.OrderRepository;
import com.masai.repository.PlanterDao;
import com.masai.repository.SignUpDao;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repository;
	@Autowired
    PlanterDao planterdao;
	@Autowired
	private SignUpDao signupdao;
	//	Adding Order
	
	@Override
	public Orders addOrder(Orders order,Integer planterid) throws OrderException {
		
		
		Optional<Planter> p=planterdao.findById(planterid);
		if(!p.isPresent()) {
			throw new OrderException("No planter found with given id");
		}
		
		
		order.getPlanters().add(p.get());
		Integer totalcost=p.get().getPlanterCost()*order.getQuantity();
		order.setTotalCost(totalcost);
		order.setLocalDate(LocalDate.now());
		
		return repository.save(order);
			
		
	}

	
	
	@Override
	public Orders updateOrder(Orders order) throws OrderException {

		Orders od= repository.findById(order.getOrderId())
				.orElseThrow(()-> new OrderException("Currently no Order available with this orderId"));
            
		List<Planter> planters=order.getPlanters();
		List<Plant> plants=order.getPlants();
		List<Seed> seeds=order.getSeeds();
		
		Integer totalcost=0;
		if(planters.size()>0) {
			for(Planter p:planters) {
				totalcost+=p.getPlanterCost();
			}
		}
		
		if(plants.size()>0) {
			for(Plant p:plants) {
				totalcost+=p.getPlantsCost();
			}
		}
		
		
		if(seeds.size()>0) {
			for(Seed s:seeds) {
				totalcost+=s.getSeedsCost();
			}
		}
		od.setTotalCost(totalcost);
		
		return repository.save(od);
	}

	@Override
	public Orders deleteOrder(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub
			Orders od=repository.findById(orderId).orElseThrow(()->new OrderException("Currently no Order available with this orderId"));
			repository.deleteById(orderId);
			return od;
	}

	@Override
	public Orders viewOrder(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub
		Orders od=repository.findById(orderId).orElseThrow(()->new OrderException("Currently no Order available with this orderId"));
		return od;
	}

	@Override
	public List<Orders> viewAllOrders() throws OrderException {
		// TODO Auto-generated method stub
		List<Orders>od= repository.findAll();
		if(od.isEmpty()) {
			throw new OrderException("No order has been orderd");
		}
		
		return od;
	}



	@Override
	public SignUpData viewcustomer(Integer orderid)throws OrderException {
		
		Optional<Orders> orderdata=repository.findById(orderid);
		if(!orderdata.isPresent()) {
			throw new OrderException("no order id found");
		}
		Optional<SignUpData> customer=signupdao.findById(orderdata.get().getUserid());
		
		return customer.get();
	
	}



	@Override
	public List<Orders> viewordersbyuserid(Integer userid) throws OrderException {
		
	List<Orders> orders=repository.findByUserid(userid);
		if(orders.size()==0) {
			throw new OrderException("User doesn't have any order");
		}
		
		
		return orders;
	}
	
	
	

	
}
