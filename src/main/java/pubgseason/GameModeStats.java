
package pubgseason;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "duo",
    "duo-fpp",
    "solo",
    "solo-fpp",
    "squad",
    "squad-fpp"
})
public class GameModeStats {

    @JsonProperty("duo")
    private Duo duo;
    @JsonProperty("duo-fpp")
    private DuoFpp duoFpp;
    @JsonProperty("solo")
    private Solo solo;
    @JsonProperty("solo-fpp")
    private SoloFpp soloFpp;
    @JsonProperty("squad")
    private Squad squad;
    @JsonProperty("squad-fpp")
    private SquadFpp squadFpp;

    @JsonProperty("duo")
    public Duo getDuo() {
        return duo;
    }

    @JsonProperty("duo")
    public void setDuo(Duo duo) {
        this.duo = duo;
    }

    @JsonProperty("duo-fpp")
    public DuoFpp getDuoFpp() {
        return duoFpp;
    }

    @JsonProperty("duo-fpp")
    public void setDuoFpp(DuoFpp duoFpp) {
        this.duoFpp = duoFpp;
    }

    @JsonProperty("solo")
    public Solo getSolo() {
        return solo;
    }

    @JsonProperty("solo")
    public void setSolo(Solo solo) {
        this.solo = solo;
    }

    @JsonProperty("solo-fpp")
    public SoloFpp getSoloFpp() {
        return soloFpp;
    }

    @JsonProperty("solo-fpp")
    public void setSoloFpp(SoloFpp soloFpp) {
        this.soloFpp = soloFpp;
    }

    @JsonProperty("squad")
    public Squad getSquad() {
        return squad;
    }

    @JsonProperty("squad")
    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    @JsonProperty("squad-fpp")
    public SquadFpp getSquadFpp() {
        return squadFpp;
    }

    @JsonProperty("squad-fpp")
    public void setSquadFpp(SquadFpp squadFpp) {
        this.squadFpp = squadFpp;
    }

}
