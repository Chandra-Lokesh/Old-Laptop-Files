package com.myportfolio.portfolioms.clients;

import com.myportfolio.portfolioms.dto.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service")
public interface StockClient {
    @GetMapping("/stocks/{id}")
    Stock getStockById(@PathVariable int id);
}
