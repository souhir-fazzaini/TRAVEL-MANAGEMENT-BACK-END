package com.example.gestion.des.voyages.execption;

public enum ErrorCodes {
    VOYAGE_NOT_FOUND(1000),
    UTILISATEUR_NOT_FOUND(2000),
    RESERVATION_NOT_FOUND(2000),
    PASSAGER_NOT_FOUND(2000),
    PAIEMENT_NOT_FOUND(2000),;

    private int id;
    ErrorCodes(int id)
    {
        this.id=id;
    }

    public int getId()
    {
        return id;
    }




}

