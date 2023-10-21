package com.SmashPicker.SmashPicker.Controller;

import com.SmashPicker.SmashPicker.Service.SmashCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private SmashCharacterService smashCharacterService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("test", "Mark Moreno");
        model.addAttribute("listOfCharacterNames", getListOfCharacterNames());
        return "index";
    }

    public List<String> getListOfCharacterNames() {
        return smashCharacterService.getAllCharacterNames();
    }
}
