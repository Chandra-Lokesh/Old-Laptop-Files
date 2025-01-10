package com.myportfolio.portfolioms.api;

import com.myportfolio.portfolioms.model.Portfolio;
import com.myportfolio.portfolioms.service.PortfolioService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/portfolio")
public class PorfolioApi {

    private static final Logger log = LoggerFactory.getLogger(PorfolioApi.class);
    @Autowired
    private PortfolioService portfolioService;

    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio){
        return portfolioService.createPortfolio(portfolio);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(fallbackMethod = "getPortfolioByIdFallback", name = "stocks-service-cb")
    public Portfolio getPortfolioById(@PathVariable String id){
        return portfolioService.getById(id);
    }


    public Portfolio getPortfolioByIdFallback(@PathVariable String id, Throwable error) {
        log.error(error.toString());
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,error.getMessage());
    }


}
