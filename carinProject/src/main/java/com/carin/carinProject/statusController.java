package com.carin.carinProject;

import com.carin.carinProject.classes.Status;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/status")
public class statusController {

    @GetMapping
    public Status getStatus(){
        return new Status();
    }

    public static class PauseController {
    }
}
