package com.luv2code.springdemo.mvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
	private OrderRepository orderService = new OrderServiceImpl();
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String getOrderPage(Model model) {
		//System.out.println("SD");
		List<Order> orders = orderService.getAll();
		//System.out.println(orders);
        model.addAttribute("orderList", orders);
        return "order";
    }
	
	@RequestMapping(value = "/add-new-order", method=RequestMethod.GET)
    public String addNewOrderPage() {
        return "addNewOrder";
    }
	@RequestMapping(value="/add-new-order", method=RequestMethod.POST)
    public String addNewOrder(@RequestParam(value="title") String title, @RequestParam(value="price") Double price) {
        Order order = new Order();
        order.setTitle(title);
        order.setPrice(price);
        //System.out.println(order.getTitle());
        //System.out.println(order.getPrice());
        orderService.save(order);
        System.out.println(orderService.getAll());
        return "redirect:/";
    }
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteItem(@PathVariable Integer id) {
		System.out.println(orderService.getById(id-1));
		Order order = orderService.getById(id-1);
        orderService.delete(order);
        return "redirect:/";
    }
}
