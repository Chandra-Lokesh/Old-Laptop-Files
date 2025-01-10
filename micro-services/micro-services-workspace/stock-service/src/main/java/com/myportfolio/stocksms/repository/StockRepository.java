package com.myportfolio.stocksms.repository;

import com.myportfolio.stocksms.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

public interface StockRepository extends JpaRepository<Stock, Integer> {


}
