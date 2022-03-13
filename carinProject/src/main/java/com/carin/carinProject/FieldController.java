package com.carin.carinProject;

import com.carin.carinProject.classes.ConfigImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/field")
public class FieldController {

    @GetMapping
    public static List<ConfigImp> getSizeMap() throws FileNotFoundException, IOException{
        ConfigImp.ReadFile();
        return List.of(new ConfigImp());
    }
}
