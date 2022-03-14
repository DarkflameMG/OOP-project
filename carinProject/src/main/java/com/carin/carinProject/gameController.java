package com.carin.carinProject;

import com.carin.carinProject.classes.GameData;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "gamedata")
public class gameController {

    @GetMapping
    public GameData getGameData(){
        return GameDataService.getGameData();
    }

    @PutMapping("/put")
    public GameData putGameData(@RequestBody GameData gameData){
        GameDataService.setGameData(gameData);
        return GameDataService.getGameData();
    }

}