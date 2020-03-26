
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
    "gameId",
    "platformId",
    "gameCreation",
    "gameDuration",
    "queueId",
    "mapId",
    "seasonId",
    "gameVersion",
    "gameMode",
    "gameType",
    "teams",
    "participants",
    "participantIdentities"
})
public class Match {

    @JsonProperty("gameId")
    private Long gameId;
    @JsonProperty("platformId")
    private String platformId;
    @JsonProperty("gameCreation")
    private Long gameCreation;
    @JsonProperty("gameDuration")
    private Long gameDuration;
    @JsonProperty("queueId")
    private Integer queueId;
    @JsonProperty("mapId")
    private Integer mapId;
    @JsonProperty("seasonId")
    private Integer seasonId;
    @JsonProperty("gameVersion")
    private String gameVersion;
    @JsonProperty("gameMode")
    private String gameMode;
    @JsonProperty("gameType")
    private String gameType;
    @JsonProperty("teams")
    private List<Team> teams = null;
    @JsonProperty("participants")
    private List<Participant> participants = null;
    @JsonProperty("participantIdentities")
    private List<ParticipantIdentity> participantIdentities = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("gameId")
    public Long getGameId() {
        return gameId;
    }

    @JsonProperty("gameId")
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    @JsonProperty("platformId")
    public String getPlatformId() {
        return platformId;
    }

    @JsonProperty("platformId")
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @JsonProperty("gameCreation")
    public Long getGameCreation() {
        return gameCreation;
    }

    @JsonProperty("gameCreation")
    public void setGameCreation(Long gameCreation) {
        this.gameCreation = gameCreation;
    }

    @JsonProperty("gameDuration")
    public Long getGameDuration() {
        return gameDuration;
    }

    @JsonProperty("gameDuration")
    public void setGameDuration(Long gameDuration) {
        this.gameDuration = gameDuration;
    }

    @JsonProperty("queueId")
    public Integer getQueueId() {
        return queueId;
    }

    @JsonProperty("queueId")
    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    @JsonProperty("mapId")
    public Integer getMapId() {
        return mapId;
    }

    @JsonProperty("mapId")
    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    @JsonProperty("seasonId")
    public Integer getSeasonId() {
        return seasonId;
    }

    @JsonProperty("seasonId")
    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    @JsonProperty("gameVersion")
    public String getGameVersion() {
        return gameVersion;
    }

    @JsonProperty("gameVersion")
    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    @JsonProperty("gameMode")
    public String getGameMode() {
        return gameMode;
    }

    @JsonProperty("gameMode")
    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    @JsonProperty("gameType")
    public String getGameType() {
        return gameType;
    }

    @JsonProperty("gameType")
    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    @JsonProperty("teams")
    public List<Team> getTeams() {
        return teams;
    }

    @JsonProperty("teams")
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @JsonProperty("participants")
    public List<Participant> getParticipants() {
        return participants;
    }

    @JsonProperty("participants")
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    @JsonProperty("participantIdentities")
    public List<ParticipantIdentity> getParticipantIdentities() {
        return participantIdentities;
    }

    @JsonProperty("participantIdentities")
    public void setParticipantIdentities(List<ParticipantIdentity> participantIdentities) {
        this.participantIdentities = participantIdentities;
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
