package org.example.heat_beater;


import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.NonSparseToSparse;

public class Sparse {
    public static void main(String[] args) throws Exception {
        ConverterUtils.DataSource source = new ConverterUtils.DataSource("dataset_arff/github_ecg.arff");
        Instance sp = source.getDataSet().get(3);
        System.out.println(sp);

        NonSparseToSparse filter = new NonSparseToSparse();
        filter.setInputFormat(sp.dataset());

        Instances sparse = Filter.useFilter(sp.dataset(), filter);

        ArffSaver saver = new ArffSaver();
        saver.setInstances(sparse);
        saver.setFile(new java.io.File("dataset_arff/github_ecg_sparse.arff"));
        saver.writeBatch();

    }
}
