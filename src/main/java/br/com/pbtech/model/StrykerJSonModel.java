
package br.com.pbtech.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "files",
        "schemaVersion",
        "thresholds"
})
public class StrykerJSonModel {

    @JsonProperty("files")
    private Files files;
    @JsonProperty("schemaVersion")
    private String schemaVersion;
    @JsonProperty("thresholds")
    private Thresholds thresholds;

    @JsonProperty("files")
    public Files getFiles() {
        return files;
    }

    @JsonProperty("files")
    public void setFiles(Files files) {
        this.files = files;
    }

    @JsonProperty("schemaVersion")
    public String getSchemaVersion() {
        return schemaVersion;
    }

    @JsonProperty("schemaVersion")
    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    @JsonProperty("thresholds")
    public Thresholds getThresholds() {
        return thresholds;
    }

    @JsonProperty("thresholds")
    public void setThresholds(Thresholds thresholds) {
        this.thresholds = thresholds;
    }

}