
package responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeBody {

    @JsonProperty("etag")
    private String etag;

    @JsonProperty("items")
    private List<Item> items;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("nextPageToken")
    private String nextPageToken;

    @JsonProperty("pageInfo")
    private PageInfo pageInfo;

    @JsonProperty("prevPageToken")
    private String prevPageToken;

    @JsonProperty("regionCode")
    private String regionCode;

    @JsonProperty("id")
    private String id;

    public YouTubeBody(String etag, List<Item> items, String kind, String nextPageToken,
                       PageInfo pageInfo, String prevPageToken, String regionCode, String id) {
        this.etag = etag;
        this.items = items;
        this.kind = kind;
        this.nextPageToken = nextPageToken;
        this.pageInfo = pageInfo;
        this.prevPageToken = prevPageToken;
        this.regionCode = regionCode;
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getPrevPageToken() {
        return prevPageToken;
    }

    public void setPrevPageToken(String prevPageToken) {
        this.prevPageToken = prevPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getThumbnailUrl(int itemNumber) {
        return items.get(itemNumber).getSnippet().getThumbnails().getHigh().getUrl();
    }

    public String getTitle(int itemNumber) {
        return items.get(itemNumber).getSnippet().getTitle();
    }

    public String getDescription(int itemNumber) {
        return items.get(itemNumber).getSnippet().getDescription();
    }

    public String getChannelId(int itemNumber) {
        return items.get(itemNumber).getSnippet().getChannelId();
    }

    public String getChannelTitle(int itemNumber) {
        return items.get(itemNumber).getSnippet().getChannelTitle();
    }

    public String getPublishDate(int itemNumber) {
        return items.get(itemNumber).getSnippet().getPublishedAt();
    }

    public String getThumbnailUrl() {
        return items.get(0).getSnippet().getThumbnails().getHigh().getUrl();
    }

    public String getTitle() {
        return items.get(0).getSnippet().getTitle();
    }

    public String getDescription() {
        return items.get(0).getSnippet().getDescription();
    }

    public String getChannelId() {
        return items.get(0).getSnippet().getChannelId();
    }

    public String getChannelTitle() {
        return items.get(0).getSnippet().getChannelTitle();
    }

    public String getPublishDate() {
        return items.get(0).getSnippet().getPublishedAt();
    }
}
