package main;

import UserInterface.MainForm;
import UserInterface.SearchResult;
import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;
import responses.YouTubeBody;
import services.ApiService;
import threads.ThumbnailsThread;

import java.io.IOException;

public class Main {
    private static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
    private static final MainForm mainForm = new MainForm();

    public static void main(String[] args) throws IOException {
        ApiService apiService = new ApiService();

        //поиск видео
        YouTubeBody bodyWithVideos = apiService
                .sendGetRequestForSearchValue(config.baseURL(), "snippet", "1",
                        "hello", config.apiKey())
                .getYouTubeBody();
        //YouTubeBody body = apiService.sendGetRequest(config.baseURL(), "snippet", "1",
        // mainForm.getSearchRequest(), config.apiKey()).getYouTubeBody();

        System.out.println(bodyWithVideos.getThumbnailUrl());


        //поток получение замбиков (дописать в соответствии с ЮИ)

        /*ThumbnailsThread thumbnailsThread = new ThumbnailsThread(bodyWithVideos
                .getItems().get(0).getSnippet().getThumbnails());
        thumbnailsThread.start();
        try {
            thumbnailsThread.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        thumbnailsThread.getThumbnails();*/


        //поиск канала
        YouTubeBody bodyWithChannelInfo = apiService
                .sendGetRequestForSearchChannel(config.baseURL(), "snippet",
                        /*"UComP_epzeKzvBX156r6pm1Q"*/ bodyWithVideos.getChannelId(), config.apiKey())
                .getYouTubeBody();

        System.out.println(bodyWithChannelInfo.getThumbnailUrl());
        System.out.println(bodyWithChannelInfo.getTitle());
        System.out.println(bodyWithChannelInfo.getDescription());

        //поиск видео по каналу
        YouTubeBody bodyWithChannelsVideos = apiService
                .sendGetRequestForSearchValueByChannel(config.baseURL(), "snippet",
                        "10", bodyWithVideos.getChannelId(), "date", config.apiKey())
                .getYouTubeBody();

        for(int i=0; i<10; i++){
            System.out.println(bodyWithChannelsVideos.getTitle(i));
            System.out.println(bodyWithChannelsVideos.getChannelTitle(i));
            System.out.println(bodyWithChannelsVideos.getPublishDate(i));
        }



        /*
        SearchResult searchResult = new SearchResult(body1.getItems().get(0).getSnippet().getTitle(),
                body1.getItems().get(0).getSnippet().getChannelTitle(),
                body1.getItems().get(0).getSnippet().getPublishedAt());

        System.out.println(searchResult.toString());*/
    }
}
