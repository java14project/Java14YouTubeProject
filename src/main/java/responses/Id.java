
package responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Id {

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("videoId")
    private String videoId;

    @JsonProperty("channelId")
    private String channelId;

    public Id(String kind, String videoId, String channelId) {
        this.kind = kind;
        this.videoId = videoId;
        this.channelId = channelId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
