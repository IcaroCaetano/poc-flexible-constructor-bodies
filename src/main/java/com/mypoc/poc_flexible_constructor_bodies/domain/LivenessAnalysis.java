package com.mypoc.poc_flexible_constructor_bodies.domain;

import java.time.Instant;

public class LivenessAnalysis extends FraudAnalysis {

    private final double livenessScore;

    private LivenessAnalysis(
            String analysisId,
            String cpf,
            String personName,
            String source,
            Instant createdAt,
            double livenessScore) {

        super(
                analysisId,
                cpf,
                personName,
                source,
                createdAt);

        this.livenessScore = livenessScore;
    }

    public LivenessAnalysis(
            String cpf,
            String personName,
            String source,
            String livenessScore) {

        cpf = cpf.replaceAll("\\D", "");

        personName = personName.trim();

        source = source.toUpperCase();

        double score = Double.parseDouble(livenessScore);

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Liveness Score inválido");}

        this(
                java.util.UUID.randomUUID().toString(),
                cpf,
                personName,
                source,
                Instant.now(),
                score
        );
    }

    public double getLivenessScore() {


        return livenessScore;
    }
}