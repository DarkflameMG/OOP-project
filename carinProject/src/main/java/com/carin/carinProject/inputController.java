package com.carin.carinProject;


import com.carin.carinProject.classes.MainGame;
import com.carin.carinProject.classes.Shop;
import com.carin.carinProject.classes.TestGame;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping(path = "/input")
@CrossOrigin(origins = "*")
public class inputController {

    @Autowired
    private MainGame mainGame = MainGame.getInstance();

    @PostMapping("/startgame")
    public void add() throws SyntaxError, IOException, TokenizerError {

        mainGame.setGame_start();
        System.out.println("start");
        TestGame.Run();
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

    @PostMapping("/speedup")
    public void speedUp(){
        mainGame.increaseGame_speed();
    }

    @PostMapping("/speeddown")
    public void speedDown(){
        mainGame.decreaseGame_speed();
    }

    @PostMapping("/quit")
    public void quit(){
//        mainGame.pause();
        System.out.println("quit");
        mainGame.resume();
        mainGame.end();
    }

    @PostMapping("/restart")
    public void restart() throws SyntaxError, IOException, TokenizerError {
//        mainGame.pause();
        System.out.println("restart");
        mainGame.resume();
        mainGame.end();
        add();
    }

    @PostMapping("/getAntibodyxy")
    public void GetANtibodyXY(@RequestBody Map<String,Integer> body) throws SyntaxError, TokenizerError {
        Shop.getInstance().buy(body.get("type"),body.get("x"),body.get("y"));
    }

}
