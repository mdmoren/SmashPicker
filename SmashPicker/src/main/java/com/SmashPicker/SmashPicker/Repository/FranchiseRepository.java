package com.SmashPicker.SmashPicker.Repository;

import com.SmashPicker.SmashPicker.Entity.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise,Integer> {
    Franchise findByFranchise(String franchise);
}