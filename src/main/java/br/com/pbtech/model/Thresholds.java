
package br.com.pbtech.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "high",
        "low",
        "break"
})
public class Thresholds {

    @JsonProperty("high")
    private Integer high;
    @JsonProperty("low")
    private Integer low;
    @JsonProperty("break")
    private Object _break;

    @JsonProperty("high")
    public Integer getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(Integer high) {
        this.high = high;
    }

    @JsonProperty("low")
    public Integer getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(Integer low) {
        this.low = low;
    }

    @JsonProperty("break")
    public Object getBreak() {
        return _break;
    }

    @JsonProperty("break")
    public void setBreak(Object _break) {
        this._break = _break;
    }

}
