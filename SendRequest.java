package main.java.leetCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by qiuqian on 9/19/18.
 */
public class SendRequest {
    /*
     * Complete the function below.
     */

    static int getTopicCount(String topic) {
        String url = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + topic;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();
            if(responseCode != 200) {

            }
            BufferedReader in =new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            } in .close();
            //Map jsonMap = new Gson().fromJson(response.toString(), Map.class);
            //Map contentMap = new Gson().fromJson(jsonMap.get("parse").toString(), Map.class);
            //String text = jsonMap.get("parse").get("text");
            //System.out.println(text);
            //System.out.println((Map)jsonMap.get("parse").containsKey("text"));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        }
    }

