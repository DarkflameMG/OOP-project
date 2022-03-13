package com.carin.carinProject;

import com.carin.carinProject.classes.ConfigImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/field")
public class FieldController {

    @GetMapping
    public List<ConfigImp> getSizeMap(){
        return List.of(new ConfigImp());
    }
}
