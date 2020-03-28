
package pubgmatch;

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
    "duration",
    "gameMode",
    "titleId",
    "shardId",
    "tags",
    "mapName",
    "isCustomMatch",
    "createdAt",
    "seasonState",
    "matchType",
    "stats"
})
public class Attributes {

    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("gameMode")
    private String gameMode;
    @JsonProperty("titleId")
    private String titleId;
    @JsonProperty("shardId")
    private String shardId;
    @JsonProperty("tags")
    private Object tags;
    @JsonProperty("mapName")
    private String mapName;
    @JsonProperty("isCustomMatch")
    private Boolean isCustomMatch;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("seasonState")
    private String seasonState;
    @JsonProperty("matchType")
    private String matchType;
    @JsonProperty("stats")
    private Object stats;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("gameMode")
    public String getGameMode() {
        return gameMode;
    }

    @JsonProperty("gameMode")
    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    @JsonProperty("titleId")
    public String getTitleId() {
        return titleId;
    }

    @JsonProperty("titleId")
    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    @JsonProperty("shardId")
    public String getShardId() {
        return shardId;
    }

    @JsonProperty("shardId")
    public void setShardId(String shardId) {
        this.shardId = shardId;
    }

    @JsonProperty("tags")
    public Object getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Object tags) {
        this.tags = tags;
    }

    @JsonProperty("mapName")
    public String getMapName() {
        return mapName;
    }

    @JsonProperty("mapName")
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    @JsonProperty("isCustomMatch")
    public Boolean getIsCustomMatch() {
        return isCustomMatch;
    }

    @JsonProperty("isCustomMatch")
    public void setIsCustomMatch(Boolean isCustomMatch) {
        this.isCustomMatch = isCustomMatch;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("seasonState")
    public String getSeasonState() {
        return seasonState;
    }

    @JsonProperty("seasonState")
    public void setSeasonState(String seasonState) {
        this.seasonState = seasonState;
    }

    @JsonProperty("matchType")
    public String getMatchType() {
        return matchType;
    }

    @JsonProperty("matchType")
    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    @JsonProperty("stats")
    public Object getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Object stats) {
        this.stats = stats;
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
