package com.example.Employee_System.Service;



import com.example.Employee_System.Entity.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "stock-service", url = "http://localhost:2014/stock") // Replace URL with Stock Service URL
public interface StockClient {



    @PostMapping("/add/stock")
    String addStock(@RequestBody Stock stock);

    @GetMapping
    List<Stock> getAllStock();

    @GetMapping("/by-category")
    List<Stock> getStockByCategory(@RequestParam("category") String category);
}
