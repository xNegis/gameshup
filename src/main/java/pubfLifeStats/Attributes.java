
package pubfLifeStats;

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
    "bestRankPoint",
    "gameModeStats"
})
public class Attributes {

    @JsonProperty("bestRankPoint")
    private Integer bestRankPoint;
    @JsonProperty("gameModeStats")
    private GameModeStats gameModeStats;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bestRankPoint")
    public Integer getBestRankPoint() {
        return bestRankPoint;
    }

    @JsonProperty("bestRankPoint")
    public void setBestRankPoint(Integer bestRankPoint) {
        this.bestRankPoint = bestRankPoint;
    }

    @JsonProperty("gameModeStats")
    public GameModeStats getGameModeStats() {
        return gameModeStats;
    }

    @JsonProperty("gameModeStats")
    public void setGameModeStats(GameModeStats gameModeStats) {
        this.gameModeStats = gameModeStats;
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
