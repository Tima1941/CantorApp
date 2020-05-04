package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

//stronki z ktorych korzystalem
//        https://exchangeratesapi.io/
//        https://api.exchangeratesapi.io/latest?symbols=USD,GBP

public class HttpConnection {

    public void connection () throws IOException {
        URL url = new URL(System.getProperty("rates.http.api"));
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
//        String req_result = jsonobj.toString();
        String req_result = jsonobj.get("rates").toString();
        System.out.println(req_result);
    }
}
