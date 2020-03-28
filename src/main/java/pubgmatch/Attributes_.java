
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
    "stats",
    "won",
    "shardId",
    "actor"
})
public class Attributes_ {

    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("won")
    private String won;
    @JsonProperty("shardId")
    private String shardId;
    @JsonProperty("actor")
    private String actor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("won")
    public String getWon() {
        return won;
    }

    @JsonProperty("won")
    public void setWon(String won) {
        this.won = won;
    }

    @JsonProperty("shardId")
    public String getShardId() {
        return shardId;
    }

    @JsonProperty("shardId")
    public void setShardId(String shardId) {
        this.shardId = shardId;
    }

    @JsonProperty("actor")
    public String getActor() {
        return actor;
    }

    @JsonProperty("actor")
    public void setActor(String actor) {
        this.actor = actor;
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
