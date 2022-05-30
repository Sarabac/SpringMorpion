package com.example.demo.vue;

import com.example.demo.service.JouerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jouer")
public class JouerVue {
    @Autowired
    JouerService jouerService;

    @GetMapping("/{id}")
    public String terrain(@PathVariable("id") final int id){
        System.out.println(id);
        return "terrain";
    }
    
    @GetMapping("/")
    public String testAxios(){
        return "jouer";
    }
}
