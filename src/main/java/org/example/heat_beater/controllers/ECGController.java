package org.example.heat_beater.controllers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.heat_beater.model.ArffDataPreprocessor_model;
import org.example.heat_beater.model.HealthData;
import org.example.heat_beater.reposiotries.HealthDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Getter
@Setter
@NoArgsConstructor
public class ECGController  {

//    @Autowired
//    private HealthDataRepository healthDataRepository;
//
//    @PostMapping("/predict")
//    public String predict(@ModelAttribute("healthData") HealthData healthData) {
//        healthDataRepository.save(healthData);
//        ModelAndView modelAndView = new ModelAndView();
//        // Perform the prediction using the healthData
//        String prediction = performPrediction(healthData);
//        // Add the prediction result to the model
//        modelAndView.addObject("message", prediction);
//        // Set the view name to index to return to the same page
//        modelAndView.setViewName("index");
//        return "redirect:/result.html";
//    }
//
//    @GetMapping("/predict")
//    public List<HealthData> getPredictions() {
//        return healthDataRepository.findAll();
//    }
//
//    private String performPrediction(HealthData healthData) {
//        // Add your prediction logic here
//        return "Prediction result ";
//    }
//
//    @ModelAttribute("healthData")
//    public HealthData healthData() {
//        return new HealthData();
//    }

    private ArffDataPreprocessor_model arffs;

    private HealthDataRepository healthDataRepository;


    @Autowired
    public ECGController(ArffDataPreprocessor_model arffs, HealthDataRepository healthDataRepository) {
        this.arffs = arffs;
        this.healthDataRepository = healthDataRepository;
    }

    @PostMapping("/predict")
    public String predict(@ModelAttribute("healthData") HealthData healthData) {
        healthDataRepository.save(healthData);
        ModelAndView modelAndView = new ModelAndView();
        // Perform the prediction using the healthData
        String prediction = performPrediction(healthData);
        // Add the prediction result to the model
        modelAndView.addObject("message", prediction);
        // Set the view name to index to return to the same page
        modelAndView.setViewName("index");
        return "redirect:/result.html";
    }

    @GetMapping("/predict")
    public List<HealthData> getPredictions() {
        return healthDataRepository.findAll();
    }

    private String performPrediction(HealthData healthData) {
        // Add your prediction logic here
        return "Prediction result ";
    }

    @ModelAttribute("healthData")
    public HealthData healthData() {
        return new HealthData();
    }









}