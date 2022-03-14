package com.carin.carinProject;

import com.carin.carinProject.classes.GameData;
import org.springframework.stereotype.Service;

@Service
public class GameDataService {
    private static GameData gameData = new GameData(0,0,null,null,null,null,null,null);

    public static GameData getGameData(){
        return  gameData;
    }

    public static void setGameData(GameData gameData){
        GameDataService.gameData = gameData;
    }
}
