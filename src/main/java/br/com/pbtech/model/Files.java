
package br.com.pbtech.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Files {

    @JsonIgnore
    private Map<String, ObjectFile> additionalProperties = new HashMap<String, ObjectFile>();

    @JsonAnyGetter
    public Map<String, ObjectFile> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, ObjectFile value) {
        this.additionalProperties.put(name, value);
    }

}