package org.example.heat_beater;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;

public class ECGAnalyzer {


    public static void main(String[] args) throws Exception {
        // Load ARFF data
        ArffLoader loader = new ArffLoader();
        loader.setSource(new File("dataset_arff/github_ecg.arff"));
        Instances data = loader.getDataSet();

        // Set class index (the attribute to predict)
        data.setClassIndex(data.numAttributes() - 1);

        // Build classifier
        J48 classifier = new J48();
        classifier.buildClassifier(data);

        // Print the classifier
        System.out.println(classifier);

        // Print the class index
        System.out.println(data.classIndex());

    }
    

}
