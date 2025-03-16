package com.crudoperation.jw.dto;

public class CatagorieDto {

    private int id;
    private String catagorieType;
    private String catagorieId;
    private String catagorieDescription;

    public CatagorieDto(int id, String catagorieType, String catagorieId, String catagorieDescription) {
        this.id = id;
        this.catagorieType = catagorieType;
        this.catagorieId = catagorieId;
        this.catagorieDescription = catagorieDescription;
    }
    public CatagorieDto() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatagorieType() {
        return catagorieType;
    }

    public void setCatagorieType(String catagorieType) {
        this.catagorieType = catagorieType;
    }

    public String getCatagorieId() {
        return catagorieId;
    }

    public void setCatagorieId(String catagorieId) {
        this.catagorieId = catagorieId;
    }

    public String getCatagorieDescription() {
        return catagorieDescription;
    }

    public void setCatagorieDescription(String catagorieDescription) {
        this.catagorieDescription = catagorieDescription;
    }
}
