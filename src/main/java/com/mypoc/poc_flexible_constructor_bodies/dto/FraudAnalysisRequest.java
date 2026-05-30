package com.mypoc.poc_flexible_constructor_bodies.dto;

public record FraudAnalysisRequest(
        String cpf,
        String personName,
        String source,
        String faceMatchScore,
        String livenessScore
) {
}