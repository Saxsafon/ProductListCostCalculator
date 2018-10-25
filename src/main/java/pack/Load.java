package pack;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Load {
    public static final String API_KEY = "5XPwGVnlanL7m4LKAnMNTJdptuKVyK8Q";

    public static void loadTextFile(String folderWay, String date) {
        System.out.println("I loadTextFile");
        String url = "https://forex.1forge.com/1.0.3/quotes?pairs=USDEUR,USDRUB,AUDUSD&api_key=" + API_KEY;

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            JsonParser parser = new JsonParser();
            JsonElement tradeElement = parser.parse(response.toString());
            JsonArray trade = tradeElement.getAsJsonArray();

            System.out.println(trade);

            File newFile = new File(folderWay + date + ".txt");
            if (newFile.exists()) {
                System.out.println("The file already exists");
            }
            else {
                newFile.createNewFile();
            }

            FileWriter fileW = new FileWriter(newFile);
            BufferedWriter buffW = new BufferedWriter(fileW);

            for (JsonElement item:trade) {
                System.out.println(item.getAsJsonObject().get("price"));
                buffW.write(String.valueOf(item.getAsJsonObject().get("price")));
            }
            buffW.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
