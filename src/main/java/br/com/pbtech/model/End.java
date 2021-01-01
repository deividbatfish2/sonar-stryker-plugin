
package br.com.pbtech.model;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class End {

    @JsonProperty("column")
    private Integer column;
    @JsonProperty("line")
    private Integer line;

    public End() {
    }

    public End(Integer column, Integer line) {
        this.column = column;
        this.line = line;
    }

    @JsonProperty("column")
    public Integer getColumn() {
        return column;
    }

    @JsonProperty("column")
    public void setColumn(Integer column) {
        this.column = column;
    }

    @JsonProperty("line")
    public Integer getLine() {
        return line;
    }

    @JsonProperty("line")
    public void setLine(Integer line) {
        this.line = line;
    }

}
