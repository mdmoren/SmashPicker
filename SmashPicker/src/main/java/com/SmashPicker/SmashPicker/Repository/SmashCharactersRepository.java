package com.SmashPicker.SmashPicker.Repository;

import com.SmashPicker.SmashPicker.Entity.SmashCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmashCharactersRepository extends JpaRepository<SmashCharacter,Integer> {
    List<SmashCharacter> findByFranchise(String franchise);

    SmashCharacter findByCharacterName(String characterName);
}