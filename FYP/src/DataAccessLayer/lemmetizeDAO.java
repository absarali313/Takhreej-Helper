package DataAccessLayer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject; // Import JSONObject for JSON parsing

public class lemmetizeDAO {

    public String getLemmatizedWord(String textToLemmatize) throws IOException {
        
        String lemmatizedText ="";
        URL url = new URL("http://localhost:5000/lemmatize");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonInputString = "{\"text\": \"" + textToLemmatize + "\"}";
        try (java.io.OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try (Scanner scanner = new Scanner(conn.getInputStream(), "utf-8")) {
            StringBuilder responseBody = new StringBuilder();
            while (scanner.hasNextLine()) {
                responseBody.append(scanner.nextLine());
            }
            lemmatizedText = extractLemmatizedText(responseBody.toString()); // Extract lemmatized text
            System.out.println(lemmatizedText);
        }

        conn.disconnect();
        return lemmatizedText;
    }
    
    
    private static String extractLemmatizedText(String jsonResponse) {
        // Parse the JSON response
        JSONObject jsonObject = new JSONObject(jsonResponse);
        // Extract the value associated with the key "lemmatized_text"
        return jsonObject.getString("lemmatized_text");
    }

}
