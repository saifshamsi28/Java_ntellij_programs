package BusTrackingSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BusInfo {

    public static void main(String[] args) {
        String stopId = "916"; // Replace with the actual stop ID

        try {
            String url;
            url = "http://125.16.1.204:8080/vtpis/appQuery.do?query=" + stopId + ",0,67&flag=6";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                String data = response.toString();
                String[] buses = data.split(";");

                for (String bus : buses) {
                    String[] variables = bus.split(",");
                    String vehicle = variables[0];
                    String route = variables[1];
                    String direction = variables[2];
                    String eta = variables[3];

                    // Process bus information as needed
                    System.out.println("Vehicle: " + vehicle + ", Route: " + route + ", Direction: " + direction + ", ETA: " + eta);
                }
            } else {
                System.out.println("HTTP GET request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
