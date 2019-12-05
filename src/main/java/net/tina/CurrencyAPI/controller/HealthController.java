package net.tina.CurrencyAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @RequestMapping("/health")
    public String getHealth() {
        return "Hey! I'm ok!";
    }
}
