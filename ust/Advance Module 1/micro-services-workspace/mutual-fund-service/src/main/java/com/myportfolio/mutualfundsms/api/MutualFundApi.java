package com.myportfolio.mutualfundsms.api;

import com.myportfolio.mutualfundsms.model.MutualFund;
import com.myportfolio.mutualfundsms.repository.MutualFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mutualfunds")
public class MutualFundApi {

    @Autowired
    MutualFundRepository mutualFundRepo;

    @PostMapping
    public MutualFund save(@RequestBody MutualFund mutualFund){
        return mutualFundRepo.save(mutualFund);
    }

    @GetMapping
    public List<MutualFund> getAll(){
        return mutualFundRepo.findAll();
    }

    @GetMapping("/{id}")
    public MutualFund getById(@PathVariable int id){
        return mutualFundRepo.findById(id).orElse(null);
    }
}
