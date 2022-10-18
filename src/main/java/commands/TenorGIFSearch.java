package commands;

import me.michaelgu.DiscordBot;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TenorGIFSearch {
    //private static final String API_KEY = System.getenv("TENOR_KEY");
    //private static final String CLIENT_KEY = System.getenv("CLIENT_KEY");
    private static final String CLIENT_KEY = "michaelbot-1666045190509";
    private static final String API_KEY = "AIzaSyAURll-_3Ip-gLoe8iWnNkthzekJSYMcBs";

    // CODE COURTESY OF TENOR API DOCUMENTATION
    public static String searchGIF(String input) {
        String parsedInput = input.replaceAll(" ", "+");
        DiscordBot.output.println(parsedInput);
        System.out.println(parsedInput);

        JSONObject url = null;
        try {
            url = TenorGIFSearch.getSearchResults(parsedInput, 1);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        String stringURL = url.toString();
        int startIndex = stringURL.indexOf("https://");
        int finalIndex = stringURL.indexOf(".gif");
        return stringURL.substring(startIndex, finalIndex + 4);
    }

    public static JSONObject getSearchResults(String searchTerm, int limit) throws IOException {
        // make search request - using default locale of EN_US
        String url = String.format("https://tenor.googleapis.com/v2/search?q=%1$s&key=%2$s&client_key=%3$s&limit=%4$s",
                searchTerm, API_KEY, CLIENT_KEY, limit);
        return get(url);
    }

    private static JSONObject get(String url) throws IOException, JSONException {
        HttpURLConnection connection = null;
        try {
            // Get request
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            // Handle failure
            int statusCode = connection.getResponseCode();
            if (statusCode != HttpURLConnection.HTTP_OK && statusCode != HttpURLConnection.HTTP_CREATED) {
                String error = String.format("HTTP Code: '%1$s' from '%2$s'", statusCode, url);
                throw new ConnectException(error);
            }

            // Parse response
            return parser(connection);
        } catch (Exception ignored) {
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return new JSONObject("");
    }

    /**
     * Parse the response into JSONObject
     */
    private static JSONObject parser(HttpURLConnection connection) throws JSONException {
        char[] buffer = new char[1024 * 4];
        int n;
        InputStream stream = null;
        try {
            stream = new BufferedInputStream(connection.getInputStream());
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
            StringWriter writer = new StringWriter();
            while (-1 != (n = reader.read(buffer))) {
                writer.write(buffer, 0, n);
            }
            return new JSONObject(writer.toString());
        } catch (IOException ignored) {
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ignored) {
                }
            }
        }
        return new JSONObject("");
    }
}
