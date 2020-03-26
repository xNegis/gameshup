
package lolmatch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "teamId",
    "win",
    "firstBlood",
    "firstTower",
    "firstInhibitor",
    "firstBaron",
    "firstDragon",
    "firstRiftHerald",
    "towerKills",
    "inhibitorKills",
    "baronKills",
    "dragonKills",
    "vilemawKills",
    "riftHeraldKills",
    "dominionVictoryScore",
    "bans"
})
public class Team {

    @JsonProperty("teamId")
    private Integer teamId;
    @JsonProperty("win")
    private String win;
    @JsonProperty("firstBlood")
    private Boolean firstBlood;
    @JsonProperty("firstTower")
    private Boolean firstTower;
    @JsonProperty("firstInhibitor")
    private Boolean firstInhibitor;
    @JsonProperty("firstBaron")
    private Boolean firstBaron;
    @JsonProperty("firstDragon")
    private Boolean firstDragon;
    @JsonProperty("firstRiftHerald")
    private Boolean firstRiftHerald;
    @JsonProperty("towerKills")
    private Integer towerKills;
    @JsonProperty("inhibitorKills")
    private Integer inhibitorKills;
    @JsonProperty("baronKills")
    private Integer baronKills;
    @JsonProperty("dragonKills")
    private Integer dragonKills;
    @JsonProperty("vilemawKills")
    private Integer vilemawKills;
    @JsonProperty("riftHeraldKills")
    private Integer riftHeraldKills;
    @JsonProperty("dominionVictoryScore")
    private Integer dominionVictoryScore;
    @JsonProperty("bans")
    private List<Ban> bans = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("teamId")
    public Integer getTeamId() {
        return teamId;
    }

    @JsonProperty("teamId")
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("win")
    public String getWin() {
        return win;
    }

    @JsonProperty("win")
    public void setWin(String win) {
        this.win = win;
    }

    @JsonProperty("firstBlood")
    public Boolean getFirstBlood() {
        return firstBlood;
    }

    @JsonProperty("firstBlood")
    public void setFirstBlood(Boolean firstBlood) {
        this.firstBlood = firstBlood;
    }

    @JsonProperty("firstTower")
    public Boolean getFirstTower() {
        return firstTower;
    }

    @JsonProperty("firstTower")
    public void setFirstTower(Boolean firstTower) {
        this.firstTower = firstTower;
    }

    @JsonProperty("firstInhibitor")
    public Boolean getFirstInhibitor() {
        return firstInhibitor;
    }

    @JsonProperty("firstInhibitor")
    public void setFirstInhibitor(Boolean firstInhibitor) {
        this.firstInhibitor = firstInhibitor;
    }

    @JsonProperty("firstBaron")
    public Boolean getFirstBaron() {
        return firstBaron;
    }

    @JsonProperty("firstBaron")
    public void setFirstBaron(Boolean firstBaron) {
        this.firstBaron = firstBaron;
    }

    @JsonProperty("firstDragon")
    public Boolean getFirstDragon() {
        return firstDragon;
    }

    @JsonProperty("firstDragon")
    public void setFirstDragon(Boolean firstDragon) {
        this.firstDragon = firstDragon;
    }

    @JsonProperty("firstRiftHerald")
    public Boolean getFirstRiftHerald() {
        return firstRiftHerald;
    }

    @JsonProperty("firstRiftHerald")
    public void setFirstRiftHerald(Boolean firstRiftHerald) {
        this.firstRiftHerald = firstRiftHerald;
    }

    @JsonProperty("towerKills")
    public Integer getTowerKills() {
        return towerKills;
    }

    @JsonProperty("towerKills")
    public void setTowerKills(Integer towerKills) {
        this.towerKills = towerKills;
    }

    @JsonProperty("inhibitorKills")
    public Integer getInhibitorKills() {
        return inhibitorKills;
    }

    @JsonProperty("inhibitorKills")
    public void setInhibitorKills(Integer inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    @JsonProperty("baronKills")
    public Integer getBaronKills() {
        return baronKills;
    }

    @JsonProperty("baronKills")
    public void setBaronKills(Integer baronKills) {
        this.baronKills = baronKills;
    }

    @JsonProperty("dragonKills")
    public Integer getDragonKills() {
        return dragonKills;
    }

    @JsonProperty("dragonKills")
    public void setDragonKills(Integer dragonKills) {
        this.dragonKills = dragonKills;
    }

    @JsonProperty("vilemawKills")
    public Integer getVilemawKills() {
        return vilemawKills;
    }

    @JsonProperty("vilemawKills")
    public void setVilemawKills(Integer vilemawKills) {
        this.vilemawKills = vilemawKills;
    }

    @JsonProperty("riftHeraldKills")
    public Integer getRiftHeraldKills() {
        return riftHeraldKills;
    }

    @JsonProperty("riftHeraldKills")
    public void setRiftHeraldKills(Integer riftHeraldKills) {
        this.riftHeraldKills = riftHeraldKills;
    }

    @JsonProperty("dominionVictoryScore")
    public Integer getDominionVictoryScore() {
        return dominionVictoryScore;
    }

    @JsonProperty("dominionVictoryScore")
    public void setDominionVictoryScore(Integer dominionVictoryScore) {
        this.dominionVictoryScore = dominionVictoryScore;
    }

    @JsonProperty("bans")
    public List<Ban> getBans() {
        return bans;
    }

    @JsonProperty("bans")
    public void setBans(List<Ban> bans) {
        this.bans = bans;
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
