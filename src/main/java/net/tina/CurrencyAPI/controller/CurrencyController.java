package net.tina.CurrencyAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
    private Map<String, Double> data;

    @Autowired
    private void fillData() {
        data = new HashMap();
        data.put("USDKGS", 69.848);
        data.put("USDEUR", 0.901845);
    }

    @RequestMapping(value = "/convert", method = RequestMethod.GET)
    public String getConverted(@RequestParam(value = "amount") Double amount,
                               @RequestParam(value = "source") String source,
                               @RequestParam(value = "target") String target) {
        System.out.println("Amount:" + amount);
        System.out.println("Source:" + source);
        System.out.println("Target:" + target);

        Double convertedAmount = 0d;
        if (data.containsKey(source + target)) {
            return "Amount:" + amount + " source:" + source + " target:" + target + " converted amount:" + convertedAmount;
        } else {
            return "There is no such currency";
        }
    }

    @RequestMapping("/allCurrencies")
    public Map<String, Double> getAllCurrencies() {
        return data;
    }
}
