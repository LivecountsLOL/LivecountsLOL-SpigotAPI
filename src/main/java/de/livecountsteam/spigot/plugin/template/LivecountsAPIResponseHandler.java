package de.livecountsteam.spigot.plugin.template;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.List;

public class LivecountsAPIResponseHandler {

    public static long extractSubscriberCount(String responseData) throws ParseException {
        JSONObject jsonObject = parseJSON(responseData);
        JSONObject dataContents = (JSONObject) jsonObject.get("DataContents");
        JSONObject channelEstParams = (JSONObject) dataContents.get("ChannelEstParams");
        return (Long) channelEstParams.get("followerCount");
    }

    public static long extractViewCount(String responseData) throws ParseException {
        JSONObject jsonObject = parseJSON(responseData);
        JSONObject dataContents = (JSONObject) jsonObject.get("DataContents");
        JSONObject channelEstParams = (JSONObject) dataContents.get("ChannelEstParams");
        return (Long) channelEstParams.get("viewsCountAPI");
    }

    public static long extractVideoCount(String responseData) throws ParseException {
        JSONObject jsonObject = parseJSON(responseData);
        JSONObject dataContents = (JSONObject) jsonObject.get("DataContents");
        JSONObject channelEstParams = (JSONObject) dataContents.get("ChannelEstParams");
        // Video count is not available yet, respond with "0".
        return 0;
    }

    public static List<Long> extractViewGains(String responseData) throws ParseException {
        JSONObject jsonObject = parseJSON(responseData);
        JSONArray viewGains = (JSONArray) jsonObject.get("stats");
        List<Long> viewGainsList = new ArrayList<>();
        for (Object viewGain : viewGains) {
            viewGainsList.add((Long) viewGain);
        }
        return viewGainsList;
    }

    private static JSONObject parseJSON(String responseData) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(responseData);
    }
}