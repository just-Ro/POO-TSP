package ant_colony_optimization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;

public class Names {
    public static void main(String[] args) throws Exception {
        try {
            URL url = new URL("https://parseapi.back4app.com/classes/Complete_List_Names/name?keys=Name");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestProperty("X-Parse-Application-Id", "zsSkPsDYTc2hmphLjjs9hz2Q3EXmnSxUyXnouj1I"); // This is the fake app's application id
            urlConnection.setRequestProperty("X-Parse-Master-Key", "4LuCXgPPXXO2sU5cXm6WwpwzaKyZpo3Wpj4G4xXK"); // This is the fake app's readonly master key
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                JSONObject data = new JSONObject(stringBuilder.toString()); // Here you have the data that you need
                System.out.println(data.toString(2));
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}