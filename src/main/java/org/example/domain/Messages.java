package org.example.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "msg")
public class Messages {

    public Long getPRIMARY_KEY() {
        return PRIMARY_KEY;
    }

    public void setPRIMARY_KEY(long PRIMARY_KEY) {
        this.PRIMARY_KEY = PRIMARY_KEY;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getUPDATED_TIMESTAMP() {
        return UPDATED_TIMESTAMP;
    }

    public void setUPDATED_TIMESTAMP(String UPDATED_TIMESTAMP) {
        this.UPDATED_TIMESTAMP = UPDATED_TIMESTAMP;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long PRIMARY_KEY;
    private String NAME;
    private String DESCRIPTION;
    private String UPDATED_TIMESTAMP;



}

