package com.SmashPicker.SmashPicker.Controller;

import com.SmashPicker.SmashPicker.Service.SmashCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private SmashCharacterService smashCharacterService;

    @GetMapping("/getCharacterDetails/{characterName}")
    public Map<String, Object> fetchDetailsByID(@PathVariable String characterName) {
        return smashCharacterService.getCharacterDetailsByName(characterName);
    }

    @GetMapping("/getListOfCharacters")
    public List<String> getListOfCharacterNames() {
        return smashCharacterService.getAllCharacterNames();
    }
}