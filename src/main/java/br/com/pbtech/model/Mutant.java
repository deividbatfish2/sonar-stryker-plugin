
package br.com.pbtech.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mutant {

    @JsonProperty("id")
    private String id;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("mutatorName")
    private String mutatorName;
    @JsonProperty("replacement")
    private String replacement;
    @JsonProperty("status")
    private String status;
    @JsonProperty("description")
    private String description;

    public Mutant() {
    }

    public Mutant(String id, Location location, String mutatorName, String replacement, String status, String description) {
        this.id = id;
        this.location = location;
        this.mutatorName = mutatorName;
        this.replacement = replacement;
        this.status = status;
        this.description = description;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("mutatorName")
    public String getMutatorName() {
        return mutatorName;
    }

    @JsonProperty("mutatorName")
    public void setMutatorName(String mutatorName) {
        this.mutatorName = mutatorName;
    }

    @JsonProperty("replacement")
    public String getReplacement() {
        return replacement;
    }

    @JsonProperty("replacement")
    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

}