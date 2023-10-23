package com.SmashPicker.SmashPicker.Controller;

import com.SmashPicker.SmashPicker.Service.SmashCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ClientController {

    private final SmashCharacterService smashCharacterService;

    @Autowired
    public ClientController(SmashCharacterService smashCharacterService) {
        this.smashCharacterService = smashCharacterService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<String> listOfCharacterNames = smashCharacterService.getAllCharacterNames();
        model.addAttribute("listOfCharacterNames", listOfCharacterNames);
        return "index";
    }

    @GetMapping("/getCharacterDetails")
    @ResponseBody
    public Map<String, Object> getCharacterDetails(@RequestParam String characterName) {
        return smashCharacterService.getCharacterDetailsByName(characterName);
    }
}
