# Heat Beater: A Java Application for Heat Analysis

Heat Beater is a robust Java application built with Spring Boot and Maven. It leverages the power of the Weka library for data analysis and machine learning, specifically focusing on heat data.

## Project Structure

The project is structured into three main classes:

- `HeatBeaterApplication.java`: The main entry point for the Spring Boot application.
- `ECGAnalyzer.java`: Handles loading ARFF data, building a J48 classifier, and printing the classifier and class index.
- `ArffDataPreprocessor.java`: Loads an ARFF file and preprocesses the data.

## Installation

Follow these steps to get the project up and running on your local machine:

1. Clone the repository to your local machine using `git clone`.
2. Navigate to the project directory.
3. Run `mvn clean install` to build the project.

## Usage

To run the application, execute the following command in the project directory:

```bash
java -jar target/heat-beater-0.0.1-SNAPSHOT.jar
