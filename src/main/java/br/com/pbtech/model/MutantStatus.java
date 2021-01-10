package br.com.pbtech.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MutantStatus {
    SURVIVED("Survived"),
    KILLED("Killed"),
    NO_COVERAGE("No coverage"),
    RUNTIME_ERROR("Runtime error"),
    COMPILE_ERROR("Compile error"),
    TIMEOUT("Timeout");

    private String descricao;

    MutantStatus(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return this.descricao;
    }
}
