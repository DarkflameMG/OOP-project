package com.carin.carinProject.classes;

import com.carin.carinProject.GameDataService;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class Controller {

    
    
    static JSONObject input;
    public static void ReadController() throws IOException {
        ConfigImp.ReadFile();
        int m = ConfigImp.getM();
        int n = ConfigImp.getN();
        int credit = ConfigImp.getAntibody_start_credit();
        List<Integer> cost = Arrays.asList(ConfigImp.getAntibodyA_credit(),ConfigImp.getAntibodyB_credit(),ConfigImp.getAntibodyC_credit());
        List<Integer> posX = Arrays.asList(0,1,2,3,4,5);  //อันนี้ลองเซตค่าขึ้นมาเอง ค่าจริงๆจะได้จากแรนดอมสุ่มเกิด
        List<Integer> posY = Arrays.asList(0,4,3,5,1,2);
        List<Integer> hp = Arrays.asList(0,20,30,40,10,6);
        List<Integer> hpMax = Arrays.asList(10,50,30,50,30,20);
        List<Integer> type = Arrays.asList(1,1,2,3,4,5,6);
        GameData g = new GameData(m, n, credit, cost,  posX, posY, hp, hpMax, type);
        GameDataService.setGameData(g);
    }

    public static void main(String[] args) throws IOException, InterruptedException, ParseException, JSONException {
        ConfigImp.ReadFile();
        int m = ConfigImp.getM();
        int n = ConfigImp.getN();
        int credit = ConfigImp.getAntibody_start_credit();
        List<Integer> cost = Arrays.asList(ConfigImp.getAntibodyA_credit(),ConfigImp.getAntibodyB_credit(),ConfigImp.getAntibodyC_credit());
        List<Integer> posX = Arrays.asList(1,2,3,4,5);  //อันนี้ลองเซตค่าขึ้นมาเอง ค่าจริงๆจะได้จากแรนดอมสุ่มเกิด
        List<Integer> posY = Arrays.asList(4,3,5,1,2);
        List<Integer> hp = Arrays.asList(20,30,40,10,6);
        List<Integer> hpMax = Arrays.asList(50,30,50,30,20);
        List<Integer> type = Arrays.asList(1,2,3,4,5,6);
        GameData g = new GameData(m, n, credit, cost,  posX, posY, hp, hpMax, type);
        GameDataService.setGameData(g);
        
//        sendGameState(0);
    }

    @SuppressWarnings("uncheck")
    public static void sendGameData(int m, int n,  List<Integer> cost,  List<Integer> posX, List<Integer> posY, List<Integer> hp, List<Integer> hpMax, List<Integer> type) throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("m", m);
        obj.put("n", n);
        obj.put("cost", cost);
        obj.put("posX", posX);
        obj.put("posY", posY);
        obj.put("hp", hp);
        obj.put("hpMax", hpMax);
        obj.put("type", type);

        putData("http://localhost:8080/gamedata/put" , obj);
    }

    public static void sendGameState(int state) throws JSONException {

        JSONObject obj = new JSONObject();
        obj.put("state", state);
        putData("http://localhost:8080/gamedata/put" , obj);
    }

    public static void putData(String link , JSONObject data) {
        try {
            String datatostr = data.toString();

            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = datatostr.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

//            System.out.println("Response:");
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
//                System.out.println(response);
            }
//            System.out.println("---------------------");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Exit Program");
            System.exit(0);
        }

    }
}
