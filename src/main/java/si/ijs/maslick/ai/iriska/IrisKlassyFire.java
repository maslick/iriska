package si.ijs.maslick.ai.iriska;

import com.maslick.ai.klassy.classifier.AbstractClassifier;
import com.maslick.ai.klassy.io.IFileLoader;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;

import java.util.ArrayList;

import static com.maslick.ai.klassy.classifier.ClassifierType.CLASSIFICATION;
import static si.ijs.maslick.ai.iriska.FeatureHelper.*;
import static si.ijs.maslick.ai.iriska.FeatureNames.*;


public class IrisKlassyFire extends AbstractClassifier<Flower> {

    public IrisKlassyFire(IFileLoader fileLoader) {
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
        atts.add(new Attribute(SEPAL_LENGTH,               0));
        atts.add(new Attribute(SEPAL_WIDTH,                1));
        atts.add(new Attribute(PETAL_LENGTH,               2));
        atts.add(new Attribute(PETAL_WIDTH,                3));
        atts.add(new Attribute(SPECIES, classAttributeVal, 4));    // class attribute (classIndex=4)

        return atts;
    }

    @Override
    public Instance calculateFeatures(Flower data) {
        // valid instance size is 4 or 5 (with class attribute)
        Instance instance = new DenseInstance(4);

        instance.setValue(attributes.get(0), calcSepalLength(data));
        instance.setValue(attributes.get(1),  calcSepalWidth(data));
        instance.setValue(attributes.get(2), calcPetalLength(data));
        instance.setValue(attributes.get(3),  calcPetalWidth(data));

        return instance;
    }
}
