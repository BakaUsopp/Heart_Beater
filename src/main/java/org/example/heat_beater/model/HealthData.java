package org.example.heat_beater.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "health_data")
public class HealthData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int age;
    private String sex;
    private String chestPain;
    private int trestbps;
    private int chol;
    private String fbs;
    private String restecg;
    private int thalach;
    private String exang;
    private double oldpeak;
    private String slope;
    private int ca;
    private String thal;

    private String num;




}