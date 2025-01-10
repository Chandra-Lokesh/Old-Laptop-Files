package com.myportfolio.stocksms.controller;

import com.myportfolio.stocksms.dto.StockInputList;
import com.myportfolio.stocksms.model.Stock;
import com.myportfolio.stocksms.repository.StockRepository;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockApi {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable int id){
        return stockRepository.findById(id).orElseThrow(() -> new RuntimeException("User with " + id + "not found!"));
    }

    @PostMapping
    public Stock saveStock(@RequestBody Stock stock){
        return stockRepository.save(stock);
    }

    @GetMapping
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    @PostMapping("/ids/")
    public List<Stock> findAllByIds(@RequestBody StockInputList stockInputList){
        return stockRepository.findAllById(stockInputList.ids());
    }

}
