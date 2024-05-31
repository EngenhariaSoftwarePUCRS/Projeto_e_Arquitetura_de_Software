package com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature;

public class SignatureType {
    private String type;

    public SignatureType(String type) {
        String[] validTypes = {"todas", "ativas", "canceladas"};
        boolean isValid = false;
        for (String validType : validTypes) {
            if (type.equals(validType)) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Tipo de assinatura inválido");
        }
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
