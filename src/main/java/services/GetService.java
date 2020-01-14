package services;

import okhttp3.Request;

class GetService {

    Request sendGetRequestForSearchValue(String baseUrl, String partVal, String maxResults,
                                         String qVal, String keyVal){

        return new Request.Builder()
                .url(new UrlService().createUrlForSearchVideo(baseUrl, partVal, maxResults,
                        qVal, keyVal))
                .get()
                .build();
    }

    Request sendGetRequestForSearchValueByChannel(String baseUrl, String partVal, String maxResults,
                                                  String channelId, String order, String keyVal){

        return new Request.Builder()
                .url(new UrlService().createUrlForSearchValueByChannel(baseUrl, partVal, maxResults,
                        channelId, order, keyVal))
                .get()
                .build();
    }

    Request sendGetRequestForSearchChannel(String baseUrl, String partVal, String channelId, String keyVal){

        return new Request.Builder()
                .url(new UrlService().createUrlForSearchChannel(baseUrl, partVal, channelId, keyVal))
                .get()
                .build();
    }
}
