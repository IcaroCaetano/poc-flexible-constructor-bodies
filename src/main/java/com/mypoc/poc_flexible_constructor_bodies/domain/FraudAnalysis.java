package com.mypoc.poc_flexible_constructor_bodies.domain;

import java.time.Instant;
import java.util.UUID;

public class FraudAnalysis {

    protected final String analysisId;
    protected final String cpf;
    protected final String personName;
    protected final String source;
    protected final Instant createdAt;

    protected FraudAnalysis(
            String analysisId,
            String cpf,
            String personName,
            String source,
            Instant createdAt) {

        this.analysisId = analysisId;
        this.cpf = cpf;
        this.personName = personName;
        this.source = source;
        this.createdAt = createdAt;
    }

    public FraudAnalysis(
            String cpf,
            String personName,
            String source) {

        // Convert to Uppercase
        cpf = cpf.replaceAll("\\D", "");

        personName = personName.trim();

        source = source.toUpperCase();

        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido");}

        String analysisId = UUID.randomUUID().toString();

        Instant createdAt = Instant.now();

        this(
                analysisId,
                cpf,
                personName,
                source,
                createdAt
        );
    }

    public String getAnalysisId() {
        return analysisId;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPersonName() {
        return personName;
    }

    public String getSource() {
        return source;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}