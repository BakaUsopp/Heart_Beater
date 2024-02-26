package org.example.heat_beater;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.util.Scanner;

public class ArffDataPreprocessor_model {

    public static void main(String[] args) {
        try {
//            String arffFilePath = "dataset_arff/github_ecg.arff";
//
//            ArffLoader loader = new ArffLoader();
//            loader.setSource(new File(arffFilePath));
//            Instances data = loader.getDataSet();
//
//            // Set the class index to the last attribute
//            data.setClassIndex(data.numAttributes() - 1);
//
//
//
//
//
//            // Train the model
//            Classifier model = new J48();
//            model.buildClassifier(data);
//
//            System.out.println("Model trained successfully.");
//
//            File directory = new File("model");
//            if (! directory.exists()){
//                directory.mkdir();
//
//
//
//            }
//
//            // Save the model to a file
//            weka.core.SerializationHelper.write("model/github_ecg.model", model);
//
//            System.out.println("Model saved successfully.");
//
//            // Load the model from a file
//            model = (Classifier) weka.core.SerializationHelper.read("model/github_ecg.model");
//
//            System.out.println("Model loaded successfully.");
//
//            // Make a prediction
//
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("Enter the value for age:");
//            double age = scanner.nextDouble();
//
//            System.out.println("Enter the value for sex (female=0, male=1):");
//            int sex = scanner.nextInt();
//
//            System.out.println("Enter the value for chest pain (typ_angina=0, asympt=1, non_anginal=2, atyp_angina=3):");
//            int chestPain = scanner.nextInt();
//
//            System.out.println("Enter the value for trestbps:");
//            double trestbps = scanner.nextDouble();
//
//            System.out.println("Enter the value for chol:");
//            double chol = scanner.nextDouble();
//
//            System.out.println("Enter the value for fbs (t=0, f=1):");
//            int fbs = scanner.nextInt();
//
//            System.out.println("Enter the value for restecg (left_vent_hyper=0, normal=1, st_t_wave_abnormality=2):");
//            int restecg = scanner.nextInt();
//
//            System.out.println("Enter the value for thalach:");
//            double thalach = scanner.nextDouble();
//
//            System.out.println("Enter the value for exang (no=0, yes=1):");
//            int exang = scanner.nextInt();
//
//            System.out.println("Enter the value for oldpeak:");
//            double oldpeak = scanner.nextDouble();
//
//            System.out.println("Enter the value for slope (down=0, flat=1, up=2):");
//            int slope = scanner.nextInt();
//
//            System.out.println("Enter the value for ca:");
//            double ca = scanner.nextDouble();
//
//            System.out.println("Enter the value for thal (fixed_defect=0, normal=1, reversable_defect=2):");
//            int thal = scanner.nextInt();
//
//            double[] values = new double[] {age, sex, chestPain, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal};
//
//            double result = model.classifyInstance(data.instance(0));
//            System.out.println("The predicted class label: " + data.classAttribute().value((int) result));



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
            model = (Classifier) weka.core.SerializationHelper.read("model/github_ecg.model");

            System.out.println("Model loaded successfully.");

            // healthy nand unhealthy data from user and predict the result from the model

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the value for age:");
            double age = scanner.nextDouble();

            System.out.println("Enter the value for sex (female=0, male=1):");
            int sex = scanner.nextInt();

            System.out.println("Enter the value for chest pain (typ_angina=0, asympt=1, non_anginal=2, atyp_angina=3):");
            int chestPain = scanner.nextInt();

            System.out.println("Enter the value for trestbps:");
            double trestbps = scanner.nextDouble();

            System.out.println("Enter the value for chol:");
            double chol = scanner.nextDouble();

            System.out.println("Enter the value for fbs (t=0, f=1):");
            int fbs = scanner.nextInt();

            System.out.println("Enter the value for restecg (left_vent_hyper=0, normal=1, st_t_wave_abnormality=2):");
            int restecg = scanner.nextInt();

            System.out.println("Enter the value for thalach:");
            double thalach = scanner.nextDouble();

            System.out.println("Enter the value for exang (no=0, yes=1):");
            int exang = scanner.nextInt();

            System.out.println("Enter the value for oldpeak:");
            double oldpeak = scanner.nextDouble();

            System.out.println("Enter the value for slope (down=0, flat=1, up=2):");
            int slope = scanner.nextInt();

            System.out.println("Enter the value for ca:");
            double ca = scanner.nextDouble();

            System.out.println("Enter the value for thal (fixed_defect=0, normal=1, reversable_defect=2):");
            int thal = scanner.nextInt();



            double[] values = new double[] {age, sex, chestPain, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal};
            Instances test = new Instances(data);
            test.setClassIndex(test.numAttributes() - 1);
            test.add(new weka.core.DenseInstance(1.0, values));
            double result = model.classifyInstance(test.instance(0));

            System.out.println("The predicted class label: " + test.classAttribute().value((int) result));









































































        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}