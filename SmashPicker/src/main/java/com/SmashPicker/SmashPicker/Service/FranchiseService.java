package com.SmashPicker.SmashPicker.Service;

import com.SmashPicker.SmashPicker.Entity.Franchise;
import com.SmashPicker.SmashPicker.Repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepo;

    public Franchise getFranchiseDetails(String franchise) {
        return franchiseRepo.findByFranchise(franchise);
    }
}
