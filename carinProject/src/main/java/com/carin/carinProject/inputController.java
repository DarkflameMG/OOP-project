package com.carin.carinProject;


import com.carin.carinProject.classes.MainGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/input")
@CrossOrigin(origins = "*")
public class inputController {

    @Autowired
    private MainGame mainGame;

    @PostMapping("/startgame")
    public void add(){

       MainGame.getInstance().setGame_startStatic();
//       System.out.println("start");
//       return mainGame.getInstance().getGame_start();
    }

}
