package com.example.SpringBootApp;

import jakarta.persistence.*;

@Entity
@Table(name = "Code")
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uniqueCode;

    public Code(Long id, String uniqueCode) {
        this.id = id;
        this.uniqueCode = uniqueCode;
    }

    public Code() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }
}
