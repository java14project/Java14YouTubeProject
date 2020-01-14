package services;

import okhttp3.HttpUrl;

public class UrlService {

    HttpUrl createUrlForSearchVideo(String baseUrl, String partVal, String maxResults,
                                    String qVal, String keyVal){

        return HttpUrl.parse(baseUrl)
                .newBuilder()
                .addPathSegment("search")
                .addQueryParameter("part", partVal)
                .addQueryParameter("maxResults", maxResults)
                .addQueryParameter("q", qVal)
                .addQueryParameter("key", keyVal)
                .build();
    }

    HttpUrl createUrlForSearchChannel(String baseUrl, String partVal, String channelId,
                                      String keyVal){

        return HttpUrl.parse(baseUrl)
                .newBuilder()
                .addPathSegment("channels")
                .addQueryParameter("part", partVal)
                //.addQueryParameter("maxResults", maxResults)
                .addQueryParameter("id", channelId)
                .addQueryParameter("key", keyVal)
                .build();
    }

    HttpUrl createUrlForSearchValueByChannel(String baseUrl, String partVal, String maxResults,
                                             String channelId, String order, String keyVal){

        return HttpUrl.parse(baseUrl)
                .newBuilder()
                .addPathSegment("channels")
                .addQueryParameter("part", partVal)
                .addQueryParameter("maxResults", maxResults)
                .addQueryParameter("id", channelId)
                .addQueryParameter("order", order)
                .addQueryParameter("key", keyVal)
                .build();
    }
}
