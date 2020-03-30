
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
    "matchesSquadFPP",
    "season",
    "player",
    "matchesSolo",
    "matchesSoloFPP",
    "matchesDuo",
    "matchesDuoFPP",
    "matchesSquad"
})
public class Relationships {

    @JsonProperty("matchesSquadFPP")
    private MatchesSquadFPP matchesSquadFPP;
    @JsonProperty("season")
    private Season season;
    @JsonProperty("player")
    private Player player;
    @JsonProperty("matchesSolo")
    private MatchesSolo matchesSolo;
    @JsonProperty("matchesSoloFPP")
    private MatchesSoloFPP matchesSoloFPP;
    @JsonProperty("matchesDuo")
    private MatchesDuo matchesDuo;
    @JsonProperty("matchesDuoFPP")
    private MatchesDuoFPP matchesDuoFPP;
    @JsonProperty("matchesSquad")
    private MatchesSquad matchesSquad;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("matchesSquadFPP")
    public MatchesSquadFPP getMatchesSquadFPP() {
        return matchesSquadFPP;
    }

    @JsonProperty("matchesSquadFPP")
    public void setMatchesSquadFPP(MatchesSquadFPP matchesSquadFPP) {
        this.matchesSquadFPP = matchesSquadFPP;
    }

    @JsonProperty("season")
    public Season getSeason() {
        return season;
    }

    @JsonProperty("season")
    public void setSeason(Season season) {
        this.season = season;
    }

    @JsonProperty("player")
    public Player getPlayer() {
        return player;
    }

    @JsonProperty("player")
    public void setPlayer(Player player) {
        this.player = player;
    }

    @JsonProperty("matchesSolo")
    public MatchesSolo getMatchesSolo() {
        return matchesSolo;
    }

    @JsonProperty("matchesSolo")
    public void setMatchesSolo(MatchesSolo matchesSolo) {
        this.matchesSolo = matchesSolo;
    }

    @JsonProperty("matchesSoloFPP")
    public MatchesSoloFPP getMatchesSoloFPP() {
        return matchesSoloFPP;
    }

    @JsonProperty("matchesSoloFPP")
    public void setMatchesSoloFPP(MatchesSoloFPP matchesSoloFPP) {
        this.matchesSoloFPP = matchesSoloFPP;
    }

    @JsonProperty("matchesDuo")
    public MatchesDuo getMatchesDuo() {
        return matchesDuo;
    }

    @JsonProperty("matchesDuo")
    public void setMatchesDuo(MatchesDuo matchesDuo) {
        this.matchesDuo = matchesDuo;
    }

    @JsonProperty("matchesDuoFPP")
    public MatchesDuoFPP getMatchesDuoFPP() {
        return matchesDuoFPP;
    }

    @JsonProperty("matchesDuoFPP")
    public void setMatchesDuoFPP(MatchesDuoFPP matchesDuoFPP) {
        this.matchesDuoFPP = matchesDuoFPP;
    }

    @JsonProperty("matchesSquad")
    public MatchesSquad getMatchesSquad() {
        return matchesSquad;
    }

    @JsonProperty("matchesSquad")
    public void setMatchesSquad(MatchesSquad matchesSquad) {
        this.matchesSquad = matchesSquad;
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
