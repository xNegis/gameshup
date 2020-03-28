
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
    "rank",
    "teamId",
    "DBNOs",
    "assists",
    "boosts",
    "damageDealt",
    "deathType",
    "headshotKills",
    "heals",
    "killPlace",
    "killStreaks",
    "kills",
    "longestKill",
    "name",
    "playerId",
    "revives",
    "rideDistance",
    "roadKills",
    "swimDistance",
    "teamKills",
    "timeSurvived",
    "vehicleDestroys",
    "walkDistance",
    "weaponsAcquired",
    "winPlace"
})
public class Stats {

    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("teamId")
    private Integer teamId;
    @JsonProperty("DBNOs")
    private Integer dBNOs;
    @JsonProperty("assists")
    private Integer assists;
    @JsonProperty("boosts")
    private Integer boosts;
    @JsonProperty("damageDealt")
    private Double damageDealt;
    @JsonProperty("deathType")
    private String deathType;
    @JsonProperty("headshotKills")
    private Integer headshotKills;
    @JsonProperty("heals")
    private Integer heals;
    @JsonProperty("killPlace")
    private Integer killPlace;
    @JsonProperty("killStreaks")
    private Integer killStreaks;
    @JsonProperty("kills")
    private Integer kills;
    @JsonProperty("longestKill")
    private Integer longestKill;
    @JsonProperty("name")
    private String name;
    @JsonProperty("playerId")
    private String playerId;
    @JsonProperty("revives")
    private Integer revives;
    @JsonProperty("rideDistance")
    private Double rideDistance;
    @JsonProperty("roadKills")
    private Integer roadKills;
    @JsonProperty("swimDistance")
    private Integer swimDistance;
    @JsonProperty("teamKills")
    private Integer teamKills;
    @JsonProperty("timeSurvived")
    private Double timeSurvived;
    @JsonProperty("vehicleDestroys")
    private Integer vehicleDestroys;
    @JsonProperty("walkDistance")
    private Double walkDistance;
    @JsonProperty("weaponsAcquired")
    private Integer weaponsAcquired;
    @JsonProperty("winPlace")
    private Integer winPlace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("teamId")
    public Integer getTeamId() {
        return teamId;
    }

    @JsonProperty("teamId")
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("DBNOs")
    public Integer getDBNOs() {
        return dBNOs;
    }

    @JsonProperty("DBNOs")
    public void setDBNOs(Integer dBNOs) {
        this.dBNOs = dBNOs;
    }

    @JsonProperty("assists")
    public Integer getAssists() {
        return assists;
    }

    @JsonProperty("assists")
    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    @JsonProperty("boosts")
    public Integer getBoosts() {
        return boosts;
    }

    @JsonProperty("boosts")
    public void setBoosts(Integer boosts) {
        this.boosts = boosts;
    }

    @JsonProperty("damageDealt")
    public Double getDamageDealt() {
        return damageDealt;
    }

    @JsonProperty("damageDealt")
    public void setDamageDealt(Double damageDealt) {
        this.damageDealt = damageDealt;
    }

    @JsonProperty("deathType")
    public String getDeathType() {
        return deathType;
    }

    @JsonProperty("deathType")
    public void setDeathType(String deathType) {
        this.deathType = deathType;
    }

    @JsonProperty("headshotKills")
    public Integer getHeadshotKills() {
        return headshotKills;
    }

    @JsonProperty("headshotKills")
    public void setHeadshotKills(Integer headshotKills) {
        this.headshotKills = headshotKills;
    }

    @JsonProperty("heals")
    public Integer getHeals() {
        return heals;
    }

    @JsonProperty("heals")
    public void setHeals(Integer heals) {
        this.heals = heals;
    }

    @JsonProperty("killPlace")
    public Integer getKillPlace() {
        return killPlace;
    }

    @JsonProperty("killPlace")
    public void setKillPlace(Integer killPlace) {
        this.killPlace = killPlace;
    }

    @JsonProperty("killStreaks")
    public Integer getKillStreaks() {
        return killStreaks;
    }

    @JsonProperty("killStreaks")
    public void setKillStreaks(Integer killStreaks) {
        this.killStreaks = killStreaks;
    }

    @JsonProperty("kills")
    public Integer getKills() {
        return kills;
    }

    @JsonProperty("kills")
    public void setKills(Integer kills) {
        this.kills = kills;
    }

    @JsonProperty("longestKill")
    public Integer getLongestKill() {
        return longestKill;
    }

    @JsonProperty("longestKill")
    public void setLongestKill(Integer longestKill) {
        this.longestKill = longestKill;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("playerId")
    public String getPlayerId() {
        return playerId;
    }

    @JsonProperty("playerId")
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    @JsonProperty("revives")
    public Integer getRevives() {
        return revives;
    }

    @JsonProperty("revives")
    public void setRevives(Integer revives) {
        this.revives = revives;
    }

    @JsonProperty("rideDistance")
    public Double getRideDistance() {
        return rideDistance;
    }

    @JsonProperty("rideDistance")
    public void setRideDistance(Double rideDistance) {
        this.rideDistance = rideDistance;
    }

    @JsonProperty("roadKills")
    public Integer getRoadKills() {
        return roadKills;
    }

    @JsonProperty("roadKills")
    public void setRoadKills(Integer roadKills) {
        this.roadKills = roadKills;
    }

    @JsonProperty("swimDistance")
    public Integer getSwimDistance() {
        return swimDistance;
    }

    @JsonProperty("swimDistance")
    public void setSwimDistance(Integer swimDistance) {
        this.swimDistance = swimDistance;
    }

    @JsonProperty("teamKills")
    public Integer getTeamKills() {
        return teamKills;
    }

    @JsonProperty("teamKills")
    public void setTeamKills(Integer teamKills) {
        this.teamKills = teamKills;
    }

    @JsonProperty("timeSurvived")
    public Double getTimeSurvived() {
        return timeSurvived;
    }

    @JsonProperty("timeSurvived")
    public void setTimeSurvived(Double timeSurvived) {
        this.timeSurvived = timeSurvived;
    }

    @JsonProperty("vehicleDestroys")
    public Integer getVehicleDestroys() {
        return vehicleDestroys;
    }

    @JsonProperty("vehicleDestroys")
    public void setVehicleDestroys(Integer vehicleDestroys) {
        this.vehicleDestroys = vehicleDestroys;
    }

    @JsonProperty("walkDistance")
    public Double getWalkDistance() {
        return walkDistance;
    }

    @JsonProperty("walkDistance")
    public void setWalkDistance(Double walkDistance) {
        this.walkDistance = walkDistance;
    }

    @JsonProperty("weaponsAcquired")
    public Integer getWeaponsAcquired() {
        return weaponsAcquired;
    }

    @JsonProperty("weaponsAcquired")
    public void setWeaponsAcquired(Integer weaponsAcquired) {
        this.weaponsAcquired = weaponsAcquired;
    }

    @JsonProperty("winPlace")
    public Integer getWinPlace() {
        return winPlace;
    }

    @JsonProperty("winPlace")
    public void setWinPlace(Integer winPlace) {
        this.winPlace = winPlace;
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
