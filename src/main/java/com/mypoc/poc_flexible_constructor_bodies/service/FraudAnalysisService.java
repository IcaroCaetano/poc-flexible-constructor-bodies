package com.mypoc.poc_flexible_constructor_bodies.service;


import com.mypoc.poc_flexible_constructor_bodies.domain.FaceMatchAnalysis;
import com.mypoc.poc_flexible_constructor_bodies.domain.LivenessAnalysis;
import com.mypoc.poc_flexible_constructor_bodies.dto.FraudAnalysisRequest;

public class FraudAnalysisService {

    public void analyze(FraudAnalysisRequest request) {

        var faceMatch =
                new FaceMatchAnalysis(
                        request.cpf(),
                        request.personName(),
                        request.source(),
                        request.faceMatchScore());

        var liveness =
                new LivenessAnalysis(
                        request.cpf(),
                        request.personName(),
                        request.source(),
                        request.livenessScore());

        System.out.println("Face Match Score: " + faceMatch.getFaceMatchScore());

        System.out.println("Liveness Score: " + liveness.getLivenessScore());
    }
}