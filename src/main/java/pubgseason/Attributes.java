
package pubgseason;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gameModeStats",
    "bestRankPoint"
})
public class Attributes {

    @JsonProperty("gameModeStats")
    private GameModeStats gameModeStats;
    @JsonProperty("bestRankPoint")
    private Integer bestRankPoint;

    @JsonProperty("gameModeStats")
    public GameModeStats getGameModeStats() {
        return gameModeStats;
    }

    @JsonProperty("gameModeStats")
    public void setGameModeStats(GameModeStats gameModeStats) {
        this.gameModeStats = gameModeStats;
    }

    @JsonProperty("bestRankPoint")
    public Integer getBestRankPoint() {
        return bestRankPoint;
    }

    @JsonProperty("bestRankPoint")
    public void setBestRankPoint(Integer bestRankPoint) {
        this.bestRankPoint = bestRankPoint;
    }

}
