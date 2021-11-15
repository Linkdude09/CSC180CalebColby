package edu.neumont.ccolby.controller;

import edu.neumont.ccolby.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class FileController {

    @Autowired
    ImageService IS;

    @GetMapping("/image/{name}")
    public void create() {

    }
}
