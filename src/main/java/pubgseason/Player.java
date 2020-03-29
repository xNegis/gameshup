
package pubgseason;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data"
})
public class Player {

    @JsonProperty("data")
    private Data__ data;

    @JsonProperty("data")
    public Data__ getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data__ data) {
        this.data = data;
    }

}
