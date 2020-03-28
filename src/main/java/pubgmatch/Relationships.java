
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
    "rosters",
    "assets"
})
public class Relationships {

    @JsonProperty("rosters")
    private Rosters rosters;
    @JsonProperty("assets")
    private Assets assets;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rosters")
    public Rosters getRosters() {
        return rosters;
    }

    @JsonProperty("rosters")
    public void setRosters(Rosters rosters) {
        this.rosters = rosters;
    }

    @JsonProperty("assets")
    public Assets getAssets() {
        return assets;
    }

    @JsonProperty("assets")
    public void setAssets(Assets assets) {
        this.assets = assets;
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
