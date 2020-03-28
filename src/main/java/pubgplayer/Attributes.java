
package pubgplayer;

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
    "shardId",
    "createdAt",
    "updatedAt",
    "patchVersion",
    "name",
    "stats",
    "titleId"
})
public class Attributes {

    @JsonProperty("shardId")
    private String shardId;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("patchVersion")
    private String patchVersion;
    @JsonProperty("name")
    private String name;
    @JsonProperty("stats")
    private Object stats;
    @JsonProperty("titleId")
    private String titleId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("shardId")
    public String getShardId() {
        return shardId;
    }

    @JsonProperty("shardId")
    public void setShardId(String shardId) {
        this.shardId = shardId;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("patchVersion")
    public String getPatchVersion() {
        return patchVersion;
    }

    @JsonProperty("patchVersion")
    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("stats")
    public Object getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Object stats) {
        this.stats = stats;
    }

    @JsonProperty("titleId")
    public String getTitleId() {
        return titleId;
    }

    @JsonProperty("titleId")
    public void setTitleId(String titleId) {
        this.titleId = titleId;
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
