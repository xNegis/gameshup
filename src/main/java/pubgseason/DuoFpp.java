
package pubgseason;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "assists",
    "boosts",
    "dBNOs",
    "dailyKills",
    "dailyWins",
    "damageDealt",
    "days",
    "headshotKills",
    "heals",
    "killPoints",
    "kills",
    "longestKill",
    "longestTimeSurvived",
    "losses",
    "maxKillStreaks",
    "mostSurvivalTime",
    "rankPoints",
    "rankPointsTitle",
    "revives",
    "rideDistance",
    "roadKills",
    "roundMostKills",
    "roundsPlayed",
    "suicides",
    "swimDistance",
    "teamKills",
    "timeSurvived",
    "top10s",
    "vehicleDestroys",
    "walkDistance",
    "weaponsAcquired",
    "weeklyKills",
    "weeklyWins",
    "winPoints",
    "wins"
})
public class DuoFpp {

    @JsonProperty("assists")
    private Integer assists;
    @JsonProperty("boosts")
    private Integer boosts;
    @JsonProperty("dBNOs")
    private Integer dBNOs;
    @JsonProperty("dailyKills")
    private Integer dailyKills;
    @JsonProperty("dailyWins")
    private Integer dailyWins;
    @JsonProperty("damageDealt")
    private Integer damageDealt;
    @JsonProperty("days")
    private Integer days;
    @JsonProperty("headshotKills")
    private Integer headshotKills;
    @JsonProperty("heals")
    private Integer heals;
    @JsonProperty("killPoints")
    private Integer killPoints;
    @JsonProperty("kills")
    private Integer kills;
    @JsonProperty("longestKill")
    private Integer longestKill;
    @JsonProperty("longestTimeSurvived")
    private Integer longestTimeSurvived;
    @JsonProperty("losses")
    private Integer losses;
    @JsonProperty("maxKillStreaks")
    private Integer maxKillStreaks;
    @JsonProperty("mostSurvivalTime")
    private Integer mostSurvivalTime;
    @JsonProperty("rankPoints")
    private Integer rankPoints;
    @JsonProperty("rankPointsTitle")
    private String rankPointsTitle;
    @JsonProperty("revives")
    private Integer revives;
    @JsonProperty("rideDistance")
    private Integer rideDistance;
    @JsonProperty("roadKills")
    private Integer roadKills;
    @JsonProperty("roundMostKills")
    private Integer roundMostKills;
    @JsonProperty("roundsPlayed")
    private Integer roundsPlayed;
    @JsonProperty("suicides")
    private Integer suicides;
    @JsonProperty("swimDistance")
    private Integer swimDistance;
    @JsonProperty("teamKills")
    private Integer teamKills;
    @JsonProperty("timeSurvived")
    private Integer timeSurvived;
    @JsonProperty("top10s")
    private Integer top10s;
    @JsonProperty("vehicleDestroys")
    private Integer vehicleDestroys;
    @JsonProperty("walkDistance")
    private Integer walkDistance;
    @JsonProperty("weaponsAcquired")
    private Integer weaponsAcquired;
    @JsonProperty("weeklyKills")
    private Integer weeklyKills;
    @JsonProperty("weeklyWins")
    private Integer weeklyWins;
    @JsonProperty("winPoints")
    private Integer winPoints;
    @JsonProperty("wins")
    private Integer wins;

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

    @JsonProperty("dBNOs")
    public Integer getDBNOs() {
        return dBNOs;
    }

    @JsonProperty("dBNOs")
    public void setDBNOs(Integer dBNOs) {
        this.dBNOs = dBNOs;
    }

    @JsonProperty("dailyKills")
    public Integer getDailyKills() {
        return dailyKills;
    }

    @JsonProperty("dailyKills")
    public void setDailyKills(Integer dailyKills) {
        this.dailyKills = dailyKills;
    }

    @JsonProperty("dailyWins")
    public Integer getDailyWins() {
        return dailyWins;
    }

    @JsonProperty("dailyWins")
    public void setDailyWins(Integer dailyWins) {
        this.dailyWins = dailyWins;
    }

    @JsonProperty("damageDealt")
    public Integer getDamageDealt() {
        return damageDealt;
    }

    @JsonProperty("damageDealt")
    public void setDamageDealt(Integer damageDealt) {
        this.damageDealt = damageDealt;
    }

    @JsonProperty("days")
    public Integer getDays() {
        return days;
    }

    @JsonProperty("days")
    public void setDays(Integer days) {
        this.days = days;
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

    @JsonProperty("killPoints")
    public Integer getKillPoints() {
        return killPoints;
    }

    @JsonProperty("killPoints")
    public void setKillPoints(Integer killPoints) {
        this.killPoints = killPoints;
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

    @JsonProperty("longestTimeSurvived")
    public Integer getLongestTimeSurvived() {
        return longestTimeSurvived;
    }

    @JsonProperty("longestTimeSurvived")
    public void setLongestTimeSurvived(Integer longestTimeSurvived) {
        this.longestTimeSurvived = longestTimeSurvived;
    }

    @JsonProperty("losses")
    public Integer getLosses() {
        return losses;
    }

    @JsonProperty("losses")
    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    @JsonProperty("maxKillStreaks")
    public Integer getMaxKillStreaks() {
        return maxKillStreaks;
    }

    @JsonProperty("maxKillStreaks")
    public void setMaxKillStreaks(Integer maxKillStreaks) {
        this.maxKillStreaks = maxKillStreaks;
    }

    @JsonProperty("mostSurvivalTime")
    public Integer getMostSurvivalTime() {
        return mostSurvivalTime;
    }

    @JsonProperty("mostSurvivalTime")
    public void setMostSurvivalTime(Integer mostSurvivalTime) {
        this.mostSurvivalTime = mostSurvivalTime;
    }

    @JsonProperty("rankPoints")
    public Integer getRankPoints() {
        return rankPoints;
    }

    @JsonProperty("rankPoints")
    public void setRankPoints(Integer rankPoints) {
        this.rankPoints = rankPoints;
    }

    @JsonProperty("rankPointsTitle")
    public String getRankPointsTitle() {
        return rankPointsTitle;
    }

    @JsonProperty("rankPointsTitle")
    public void setRankPointsTitle(String rankPointsTitle) {
        this.rankPointsTitle = rankPointsTitle;
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
    public Integer getRideDistance() {
        return rideDistance;
    }

    @JsonProperty("rideDistance")
    public void setRideDistance(Integer rideDistance) {
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

    @JsonProperty("roundMostKills")
    public Integer getRoundMostKills() {
        return roundMostKills;
    }

    @JsonProperty("roundMostKills")
    public void setRoundMostKills(Integer roundMostKills) {
        this.roundMostKills = roundMostKills;
    }

    @JsonProperty("roundsPlayed")
    public Integer getRoundsPlayed() {
        return roundsPlayed;
    }

    @JsonProperty("roundsPlayed")
    public void setRoundsPlayed(Integer roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    @JsonProperty("suicides")
    public Integer getSuicides() {
        return suicides;
    }

    @JsonProperty("suicides")
    public void setSuicides(Integer suicides) {
        this.suicides = suicides;
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
    public Integer getTimeSurvived() {
        return timeSurvived;
    }

    @JsonProperty("timeSurvived")
    public void setTimeSurvived(Integer timeSurvived) {
        this.timeSurvived = timeSurvived;
    }

    @JsonProperty("top10s")
    public Integer getTop10s() {
        return top10s;
    }

    @JsonProperty("top10s")
    public void setTop10s(Integer top10s) {
        this.top10s = top10s;
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
    public Integer getWalkDistance() {
        return walkDistance;
    }

    @JsonProperty("walkDistance")
    public void setWalkDistance(Integer walkDistance) {
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

    @JsonProperty("weeklyKills")
    public Integer getWeeklyKills() {
        return weeklyKills;
    }

    @JsonProperty("weeklyKills")
    public void setWeeklyKills(Integer weeklyKills) {
        this.weeklyKills = weeklyKills;
    }

    @JsonProperty("weeklyWins")
    public Integer getWeeklyWins() {
        return weeklyWins;
    }

    @JsonProperty("weeklyWins")
    public void setWeeklyWins(Integer weeklyWins) {
        this.weeklyWins = weeklyWins;
    }

    @JsonProperty("winPoints")
    public Integer getWinPoints() {
        return winPoints;
    }

    @JsonProperty("winPoints")
    public void setWinPoints(Integer winPoints) {
        this.winPoints = winPoints;
    }

    @JsonProperty("wins")
    public Integer getWins() {
        return wins;
    }

    @JsonProperty("wins")
    public void setWins(Integer wins) {
        this.wins = wins;
    }

}
