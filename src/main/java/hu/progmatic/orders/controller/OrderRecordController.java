package hu.progmatic.orders.controller;

import hu.progmatic.orders.model.OrderRecord;
import hu.progmatic.orders.service.OrderRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderRecordController {

    @Autowired
    private OrderRecordService orderRecordService;

    @GetMapping("/add")
    public String addOrderForm(Model model) {
        model.addAttribute("order", new OrderRecord());
        return "addOrder";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute OrderRecord orderRecord) {
        orderRecordService.addOrder(orderRecord);
        return "redirect:/orders";
    }

}
