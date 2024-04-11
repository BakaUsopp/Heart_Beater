package org.example.heat_beater;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.File;

public class ECGDatasetProcessor {
    public static void main(String[] args) {
        try {
            // Specify the path to your CSV file
            String csvFilePath = "dataset/mitbih_train.csv";

            // Load CSV file
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(csvFilePath));

            // Resolve duplicate attribute names
            Instances data = resolveDuplicateAttributeNames(loader.getDataSet());

            // Specify the path for the ARFF output file
            String arffFilePath = "dataset/mitbih_train_ar.arff";

            // Save ARFF file
            ArffSaver arffSaver = new ArffSaver();
            arffSaver.setInstances(data);
            arffSaver.setFile(new File(arffFilePath));
            arffSaver.writeBatch();

            System.out.println("Conversion completed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Instances resolveDuplicateAttributeNames(Instances data) {
        // Check for duplicate attribute names
        for (int i = 0; i < data.numAttributes(); i++) {
            String attributeName = data.attribute(i).name();

            // Check if the name is already used
            int index = 1;
            while (data.attribute(attributeName + "_" + index) != null) {
                index++;
            }

            // Rename the attribute if needed
            if (index > 1) {
                data.renameAttribute(i, attributeName + "_" + index);
            }
        }

        return data;
    }
}