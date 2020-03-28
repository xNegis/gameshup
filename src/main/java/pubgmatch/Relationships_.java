
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
    "team",
    "participants"
})
public class Relationships_ {

    @JsonProperty("team")
    private Team team;
    @JsonProperty("participants")
    private Participants participants;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("team")
    public Team getTeam() {
        return team;
    }

    @JsonProperty("team")
    public void setTeam(Team team) {
        this.team = team;
    }

    @JsonProperty("participants")
    public Participants getParticipants() {
        return participants;
    }

    @JsonProperty("participants")
    public void setParticipants(Participants participants) {
        this.participants = participants;
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
