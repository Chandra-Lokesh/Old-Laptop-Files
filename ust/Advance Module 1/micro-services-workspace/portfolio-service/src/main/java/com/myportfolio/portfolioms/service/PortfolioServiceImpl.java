package com.myportfolio.portfolioms.service;

import com.myportfolio.portfolioms.clients.MutualFundClient;
import com.myportfolio.portfolioms.clients.StockClient;
import com.myportfolio.portfolioms.dto.MutualFund;
import com.myportfolio.portfolioms.dto.Stock;
import com.myportfolio.portfolioms.model.Portfolio;
import com.myportfolio.portfolioms.repository.PortfolioRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PortfolioServiceImpl implements PortfolioService{

    private static final Logger log = LoggerFactory.getLogger(PortfolioServiceImpl.class);
    @Autowired
    private PortfolioRepository portfolioRepository;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private StockClient stockClient;

    @Autowired
    private MutualFundClient mutualFundClient;

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        Portfolio savedPortfolio = portfolioRepository.save(portfolio);
        savedPortfolio.setTotalValue(fetchTotalValue(savedPortfolio));
        return portfolioRepository.save(savedPortfolio);
    }

    @Override
    public Portfolio getById(String id) {

        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow(() -> new RuntimeException("Portfolio with id " + id + " not found!"));

        portfolio.setTotalValue(fetchTotalValue(portfolio));
        return portfolio;

    }

    @Override
    public double fetchTotalValue(Portfolio portfolio) {
        double totalStockValue = 0;

        for(int stockId: portfolio.getStocks()){
//            Stock stock = restTemplate.getForObject("http://STOCK-SERVICE/stocks/"+stockId, Stock.class);
            Stock stock = stockClient.getStockById(stockId);
            totalStockValue += stock.getPrice();

        }

        double totalMutualFundValue = 0;

        for(int mId: portfolio.getMutualFunds()){
//            MutualFund mf = restTemplate.getForObject("http://MUTUAL-FUND-SERVICE/mutualfunds/"+mId, MutualFund.class);
            MutualFund mf = mutualFundClient.getMutualFundById(mId);
            totalMutualFundValue += mf.getAmountInvested() * mf.getGrowthRate();

        }

        return totalStockValue + totalMutualFundValue;
    }


}
