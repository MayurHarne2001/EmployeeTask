package com.example.Stock_Service.Controller;

import com.example.Stock_Service.Entity.Stock;
import com.example.Stock_Service.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/add/stock")
    private String addStock(@RequestBody Stock stock){
        return stockService.addStock(stock);
    }

    @GetMapping
    private ResponseEntity<List<Stock>> getAllStock(){
        List<Stock> stocks= stockService.getAllStock();
        return  ResponseEntity.ok(stocks);
    }
    @GetMapping("/by-category")
    public ResponseEntity<List<Stock>> getStockByCategory(@RequestParam("category") String category) {
        List<Stock> stock = stockService.getStockByCategory(category);
        return ResponseEntity.ok(stock);
    }
}