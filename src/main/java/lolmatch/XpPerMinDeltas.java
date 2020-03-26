
package lolmatch;

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
    "10-20",
    "0-10"
})
public class XpPerMinDeltas {

    @JsonProperty("10-20")
    private Integer _1020;
    @JsonProperty("0-10")
    private Double _010;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("10-20")
    public Integer get1020() {
        return _1020;
    }

    @JsonProperty("10-20")
    public void set1020(Integer _1020) {
        this._1020 = _1020;
    }

    @JsonProperty("0-10")
    public Double get010() {
        return _010;
    }

    @JsonProperty("0-10")
    public void set010(Double _010) {
        this._010 = _010;
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
