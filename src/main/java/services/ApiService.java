package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;
import responses.YouTubeBody;

import java.io.IOException;
import java.util.Objects;

public class ApiService {

    private OkHttpClient client = new OkHttpClient();
    private GetService getService = new GetService();
    private PostService postService = new PostService();

    private Gson gson = new Gson();
    //ObjectMapper mapper = new ObjectMapper();

    public ResponceReceiver sendGetRequestForSearchValue(String baseUrl, String partVal,
                                                         String maxResults, String qVal,
                                                         String keyVal) throws IOException {

        //String asQuery = "?part=snippet&maxResults=1&q=hello&key=AIzaSyCGb80YiFrBGofQ3eB_Q_CDoC6B0lnG1n8";
        Request request = getService.sendGetRequestForSearchValue(baseUrl, partVal, maxResults, qVal, keyVal);

        try(Response response = client.newCall(request).execute()){
            String responseBody = new String(Objects.requireNonNull(response.body()).bytes());
            System.out.println(responseBody);
            JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
            response.body().close();
            return new ResponceReceiver(gson.fromJson(jsonObject, YouTubeBody.class));
        }
    }

    public ResponceReceiver sendGetRequestForSearchChannel(String baseUrl, String partVal,
                                                           String channelId, String keyVal) throws IOException {

        Request request = getService.sendGetRequestForSearchChannel(baseUrl, partVal, channelId, keyVal);

        try(Response response = client.newCall(request).execute()){
            String responseBody = new String(Objects.requireNonNull(response.body()).bytes());
            System.out.println(responseBody);
            JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
            response.body().close();
            return new ResponceReceiver(gson.fromJson(jsonObject, YouTubeBody.class));
        }
    }

    public ResponceReceiver sendGetRequestForSearchValueByChannel(String baseUrl, String partVal,
                                                                  String maxResults, String channelId,
                                                                  String order, String keyVal) throws IOException {

        Request request = getService.sendGetRequestForSearchValueByChannel(baseUrl, partVal,
                maxResults, channelId, order, keyVal);

        try(Response response = client.newCall(request).execute()){
            String responseBody = new String(Objects.requireNonNull(response.body()).bytes());
            System.out.println(responseBody);
            JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
            response.body().close();
            return new ResponceReceiver(gson.fromJson(jsonObject, YouTubeBody.class));
        }
    }


    /*public String sendPostRequest() throws IOException {

    }*/
}
