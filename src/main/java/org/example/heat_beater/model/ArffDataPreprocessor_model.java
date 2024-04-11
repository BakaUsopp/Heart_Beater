package org.example.heat_beater.model;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.beans.JavaBean;
import java.io.File;
@JavaBean
public class ArffDataPreprocessor_model {

    public static void main(String[] args) throws Exception {
        String arffFilePath = "dataset_arff/github_ecg.arff";

        ArffLoader loader = new ArffLoader();
        loader.setSource(new File(arffFilePath));
        Instances data = loader.getDataSet();

        // Set the class index to the last attribute
        data.setClassIndex(data.numAttributes() - 1);

        // Train the model
        Classifier model = new J48();
        model.buildClassifier(data);

        System.out.println("Model trained successfully.");

        File directory = new File("model");
        if (! directory.exists()){
            directory.mkdir();
        }

        // Save the model to a file
        weka.core.SerializationHelper.write("model/github_ecg.model", model);

        System.out.println("Model saved successfully.");

        // Load the model from a file
        weka.core.SerializationHelper.read("model/github_ecg.model");


        System.out.println("Model loaded successfully.");
    }
}