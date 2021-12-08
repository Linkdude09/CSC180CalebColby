package edu.neumont.ccolby.controller;

import edu.neumont.ccolby.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    public ImageService IS;


    @GetMapping("/image/{name}")
    public ResponseEntity<String> readImage(@PathVariable String name) {
        byte[] image = IS.readImage(name);
        if(image == null){
            return new ResponseEntity<String>("Image Not Found", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<String>(name, HttpStatus.OK);
        }
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/image/<name>?transform=grayscale")
    public ResponseEntity<String> ImageGrayScale(@PathVariable String filePath){
        byte[] image = IS.greyscaleImage(filePath);
        if(image == null){
            return new ResponseEntity<String>("Image Not Found", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<String>(filePath, HttpStatus.OK);
        }
    }

    @PostMapping("/image")
    public ResponseEntity<String> createImage(@RequestParam("image")MultipartFile image){
        String imageDirectory = "/image";
        String ImageName = StringUtils.cleanPath(image.getOriginalFilename());

        try{
            IS.createImage(imageDirectory, image.getBytes(), ImageName);
            return new ResponseEntity<String>(ImageName, HttpStatus.OK);
        }catch(IOException ioe){
            System.out.println(ioe);
            return new ResponseEntity<String>("Name already Exists", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/image/{name}")
    public ResponseEntity<String> deleteImage(@RequestParam String filePath){
        boolean didItWork = IS.deleteImage(filePath);
        if(didItWork){
            return new ResponseEntity<String>(filePath + " DELETED", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Image Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
