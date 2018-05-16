package si.ijs.maslick.ai.iriska;

import com.maslick.ai.klassy.io.ContextLoader;
import org.junit.Assert;
import org.junit.Test;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Testing {

    @Test
    public void testGeneratedModel() {
        IrisKlassyFire model = new IrisKlassyFire(new ContextLoader());
        Flower flower = Flower.builder()
                .setSepalLength(5.57091678078844)
                .setPetalWidth(3.09644861465126)
                .setPetalLength(1.23725924762744)
                .setPetalWidth(0.113236009159561)
                .build();

        String klass = model.classify(flower);
        Assert.assertEquals("setosa", klass);

        flower = Flower.builder()
                .setSepalLength(4.77691762776391)
                .setPetalWidth(3.77865948462588)
                .setPetalLength(1.59390335312276)
                .setPetalWidth(0.151398435020841)
                .build();

        klass = model.classify(flower);
        Assert.assertEquals("setosa", klass);

        flower = Flower.builder()
                .setSepalLength(6.8432895741882)
                .setPetalWidth(3.17436555918227)
                .setPetalLength(4.25657322635841)
                .setPetalWidth(1.50311077472507)
                .build();

        klass = model.classify(flower);
        Assert.assertEquals("versicolor", klass);

        flower = Flower.builder()
                .setSepalLength(6.23057539842681)
                .setPetalWidth(3.03298741883935)
                .setPetalLength(4.88482355399702)
                .setPetalWidth(1.52102228144702)
                .build();

        klass = model.classify(flower);
        Assert.assertEquals("versicolor", klass);

        flower = Flower.builder()
                .setSepalLength(6.85295094185716)
                .setPetalWidth(2.51646353971598)
                .setPetalLength(4.21432509213448)
                .setPetalWidth(1.74441756575054)
                .build();

        klass = model.classify(flower);
        Assert.assertEquals("virginica", klass);

        flower = Flower.builder()
                .setSepalLength(6.49528665967672)
                .setPetalWidth(3.35602021055031)
                .setPetalLength(5.84872081384769)
                .setPetalWidth(2.01056615251337)
                .build();

        klass = model.classify(flower);
        Assert.assertEquals("virginica", klass);
    }

    @Test
    public void trainModel() throws Exception {
        // Load dataset
        BufferedReader br = new BufferedReader(new InputStreamReader(new ContextLoader().getFile("iris-train.arff"), "UTF-8"));
        Instances dataset = new Instances(br);
        dataset.setClassIndex(4);

        // Split into train and test datasets
        dataset.randomize(new Random(0));
        int numberOfInstances = dataset.numInstances();
        int trainSize = Math.round(numberOfInstances * 80 / 100);
        int testSize = numberOfInstances - trainSize;
        Instances trainSet = new Instances(dataset, 0, trainSize);
        Instances testSet = new Instances(dataset, trainSize, testSize);

        // Build model
        Classifier model = new RandomForest();
        model.buildClassifier(trainSet);

        // Evaluate model (percentage split)
        Evaluation eval = new Evaluation(trainSet);
        eval.evaluateModel(model, testSet);
        System.out.println(eval.toSummaryString("\nPercentage split (80%)\n===========================\n", false));

        // Evaluate model (cross validation)
        eval = new Evaluation(trainSet);
        eval.crossValidateModel(model, trainSet, 10, new Random(1));
        System.out.println(eval.toSummaryString("\nCross validation (10 folds)\n===========================\n", false));
    }
}
