package com.SmashPicker.SmashPicker.Service;

import com.SmashPicker.SmashPicker.Entity.Franchise;
import com.SmashPicker.SmashPicker.Entity.SmashCharacter;
import com.SmashPicker.SmashPicker.Repository.SmashCharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmashCharacterService {

    @Autowired
    private SmashCharactersRepository smashCharactersRepo;

    @Autowired
    private FranchiseService franchiseService;

    public Map<String, Object> getCharacterDetailsByName(String characterName) {
        SmashCharacter currentCharacter = smashCharactersRepo.findByCharacterName(characterName);

        if (currentCharacter != null) {
            List<SmashCharacter> charactersFromSameFranchise = smashCharactersRepo.findByFranchise(currentCharacter.getFranchise());

            // Remove the currentCharacter from the list of related characters
            charactersFromSameFranchise.remove(currentCharacter);

            Map<String, Object> response = new HashMap<>();
            response.put("relatedCharacters", charactersFromSameFranchise);
            response.put("characterDetails", currentCharacter);

            // Get franchise details using the FranchiseService
            Franchise franchiseDetails = franchiseService.getFranchiseDetails(currentCharacter.getFranchise());
            response.put("franchiseDetails", franchiseDetails);

            return response;
        } else {
            // Handle the case where the character with the given name is not found.
            // You can return an appropriate response or throw an exception.
            return null;
        }
    }

    public List<String> getAllCharacterNames() {
        List<String> characterNames = new ArrayList<>();
        List<SmashCharacter> allCharacters = smashCharactersRepo.findAll();

        for (SmashCharacter character : allCharacters) {
            characterNames.add(character.getCharacterName());
        }

        return characterNames;
    }
}
