package com.carin.carinProject;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carin.carinProject.classes.Status;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/status")
public class statusController {

    @GetMapping
    public List<Status> getStatus(){
        return List.of( new Status());
    } 
}
