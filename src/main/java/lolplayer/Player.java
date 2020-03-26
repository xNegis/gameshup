
package lolplayer;

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
    "id",
    "accountId",
    "puuid",
    "name",
    "profileIconId",
    "revisionDate",
    "summonerLevel"
})
public class Player {

    @JsonProperty("id")
    private String id;
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("puuid")
    private String puuid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("profileIconId")
    private Integer profileIconId;
    @JsonProperty("revisionDate")
    private Long revisionDate;
    @JsonProperty("summonerLevel")
    private Integer summonerLevel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("accountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("accountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("puuid")
    public String getPuuid() {
        return puuid;
    }

    @JsonProperty("puuid")
    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("profileIconId")
    public Integer getProfileIconId() {
        return profileIconId;
    }

    @JsonProperty("profileIconId")
    public void setProfileIconId(Integer profileIconId) {
        this.profileIconId = profileIconId;
    }

    @JsonProperty("revisionDate")
    public Long getRevisionDate() {
        return revisionDate;
    }

    @JsonProperty("revisionDate")
    public void setRevisionDate(Long revisionDate) {
        this.revisionDate = revisionDate;
    }

    @JsonProperty("summonerLevel")
    public Integer getSummonerLevel() {
        return summonerLevel;
    }

    @JsonProperty("summonerLevel")
    public void setSummonerLevel(Integer summonerLevel) {
        this.summonerLevel = summonerLevel;
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
