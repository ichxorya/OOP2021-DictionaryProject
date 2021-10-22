package com.example.tree_dictionary_app;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class GoogleTransAPIClient {

    // Method to encode a string value using UTF-8 encoding scheme
    public static String encodeString(String encodeThis) {
        try {
            encodeThis = URLEncoder.encode(encodeThis, StandardCharsets.UTF_8.toString());
            // Replace encoded-spaces '+' with '%20'
            encodeThis = encodeThis.replace("+", "%20");

            return encodeThis;
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    public static String callGoogleTrans(String translateThis) {
        // Default query
        final String emptyQueryValue = "%3CREQUIRED%3E";
        String translateThisQuery = "q=EMPTY&target=vi&source=en";

        // Finish the query
        if (Objects.equals(translateThisQuery, "")) {
            translateThisQuery = translateThisQuery.replace("EMPTY", emptyQueryValue);
        } else {
            translateThisQuery = translateThisQuery.replace("EMPTY", translateThis);
        }

        // Json format: {"data":{"translations":[{"translatedText":"TRANSLATED WORD"}]}}
        // Length:      0123456789ABCDEFGHIJ123456789abcdefghij123456789ABCDEFGHIJ123456
        String response = getResponse(translateThisQuery);
        return response.substring(44, response.length() - 5);   // Return the translatedText only!
    }

    public static String getResponse(String translateThisQuery) {
        HttpResponse<String> response = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("accept-encoding", "application/gzip")
                .header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
                .header("x-rapidapi-key", "dfacd18491mshcaa77bed9cf5f81p1504bejsn833f6ee177ab")
                .body(translateThisQuery)
                .asString();
        return response.getBody();
    }

    public static void main(String[] args) {
        System.out.println(callGoogleTrans("bro"));
    }
}
