package com.example.Stock_Service.Service;

import com.example.Stock_Service.Entity.Stock;
import com.example.Stock_Service.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public String addStock(Stock stock){
        int rows= stockRepository.addStock(stock);
        if(rows>0){
            return "Stock added successfully";
        }
        else{
            return "Stock not added";
        }
    }

    public List<Stock> getAllStock(){
        return stockRepository.getAllStock();

    }
    public List<Stock> getStockByCategory(String category) {
        return stockRepository.getStockByCategory(category);
    }
}

