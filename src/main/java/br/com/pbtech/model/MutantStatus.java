package br.com.pbtech.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MutantStatus {
    SURVIVED("Survived"),
    KILLED("Killed"),
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
