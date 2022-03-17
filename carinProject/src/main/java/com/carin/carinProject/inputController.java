package com.carin.carinProject;


import com.carin.carinProject.classes.MainGame;
import com.carin.carinProject.classes.Shop;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


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

    @PostMapping("/speedup")
    public void speedUp(){
        mainGame.increaseGame_speed();
    }

    @PostMapping("/speeddown")
    public void speedDown(){
        mainGame.decreaseGame_speed();
    }

    @PostMapping("/getAntibodyxy")
    public void GetANtibodyXY(@RequestBody Map<String,Integer> body) throws SyntaxError, TokenizerError {
//        mainGame.resume();
//        System.out.println(x+" "+y+" "+t);
//        System.out.println(body.get("type"));
//        System.out.println(body.get("x"));
//        System.out.println(body.get("y"));
        Shop.getInstance().buy(body.get("type"),body.get("x"),body.get("y"));
    }

}
