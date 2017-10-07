package si.ijs.maslick.ai.iriska;

import com.maslick.ai.klassy.classifier.AbstractClassifier;
import com.maslick.ai.klassy.io.IFileLoader;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;

import java.util.ArrayList;

import static com.maslick.ai.klassy.classifier.ClassifierType.CLASSIFICATION;


public class Iris extends AbstractClassifier<Flower> {

    public Iris(IFileLoader fileLoader) {
        super(fileLoader);
        MODEL = "iris-random-tree.model";  // model file name without path
        classifierType = CLASSIFICATION;   // CLASSIFICATION or REGRESSION
        classIndex = 4;                    // usually comes last (4) or first (0)
        relation = "iris";                 // name of the dataset (optional)
    }

    @Override
    public ArrayList<Attribute> createAttributeList() {
        ArrayList<String> classAttributeVal = new ArrayList<>();
        classAttributeVal.add("setosa");
        classAttributeVal.add("versicolor");
        classAttributeVal.add("virginica");

        ArrayList<Attribute> atts = new ArrayList<>();

        // Weka doesn't take attribute names into account, but their order!
        // However, for clarity one should specify attribute names like below
        atts.add(new Attribute("Sepal.Length",               0));
        atts.add(new Attribute("Sepal.Width",                1));
        atts.add(new Attribute("Petal.Length",               2));
        atts.add(new Attribute("Petal.Width",                3));
        atts.add(new Attribute("Species", classAttributeVal, 4));    // class attribute (classIndex=4)

        return atts;
    }

    @Override
    public Instance calculateFeatures(Flower data) {
        // valid instance size is 4 or 5 (with class attribute)
        Instance instance = new DenseInstance(4);

        instance.setValue(attributes.get(0), data.getSepalLength());
        instance.setValue(attributes.get(1), data.getSepalWidth());
        instance.setValue(attributes.get(2), data.getPetalLength());
        instance.setValue(attributes.get(3), data.getPetalWidth());

        return instance;
    }
}
