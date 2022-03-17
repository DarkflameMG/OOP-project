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
    private MainGame mainGame = MainGame.getInstance();

    @PostMapping("/startgame")
    public void add(){

        mainGame.setGame_start();
        System.out.println("start");
    }

    @PostMapping("/pause")
    public void pause(){
        mainGame.pause();
        System.out.println("pause");
    }
//
    @PostMapping("/unpause")
    public void Unpause(){
        mainGame.resume();
    }

}
