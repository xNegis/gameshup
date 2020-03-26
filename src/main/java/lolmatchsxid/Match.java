
package lolmatchsxid;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "platformId",
    "gameId",
    "champion",
    "queue",
    "season",
    "timestamp",
    "role",
    "lane"
})
public class Match {

    @JsonProperty("platformId")
    private String platformId;
    @JsonProperty("gameId")
    private Long gameId;
    @JsonProperty("champion")
    private Integer champion;
    @JsonProperty("queue")
    private Integer queue;
    @JsonProperty("season")
    private Integer season;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("role")
    private String role;
    @JsonProperty("lane")
    private String lane;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("platformId")
    public String getPlatformId() {
        return platformId;
    }

    @JsonProperty("platformId")
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @JsonProperty("gameId")
    public Long getGameId() {
        return gameId;
    }

    @JsonProperty("gameId")
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    @JsonProperty("champion")
    public Integer getChampion() {
        return champion;
    }

    @JsonProperty("champion")
    public void setChampion(Integer champion) {
        this.champion = champion;
    }

    @JsonProperty("queue")
    public Integer getQueue() {
        return queue;
    }

    @JsonProperty("queue")
    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    @JsonProperty("season")
    public Integer getSeason() {
        return season;
    }

    @JsonProperty("season")
    public void setSeason(Integer season) {
        this.season = season;
    }

    @JsonProperty("timestamp")
    public Long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("lane")
    public String getLane() {
        return lane;
    }

    @JsonProperty("lane")
    public void setLane(String lane) {
        this.lane = lane;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
