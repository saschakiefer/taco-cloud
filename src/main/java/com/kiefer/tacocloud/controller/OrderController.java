package com.kiefer.tacocloud.controller;

import com.kiefer.tacocloud.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("orders")
public class OrderController {
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, Model model) {
        // public String processOrder(@Valid @ModelAttribute("order") Order order, Errors errors) {
        if (errors.hasErrors()) {
            log.info("Form errors: " + errors);

            model.addAttribute("order", order);
            return "orderForm";
        }

        log.info("Order submitted: " + order);

        return "redirect:/";
    }

}
