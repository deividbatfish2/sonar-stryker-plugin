
package br.com.pbtech.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "language",
        "mutants",
        "source"
})
public class ObjectFile {

    @JsonProperty("language")
    private String language;
    @JsonProperty("mutants")
    private List<Mutant> mutants = null;
    @JsonProperty("source")
    private String source;

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("mutants")
    public List<Mutant> getMutants() {
        return mutants;
    }

    @JsonProperty("mutants")
    public void setMutants(List<Mutant> mutants) {
        this.mutants = mutants;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

}
