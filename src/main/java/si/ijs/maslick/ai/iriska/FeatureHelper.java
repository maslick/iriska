package si.ijs.maslick.ai.iriska;

public class FeatureHelper {

    public static double calcSepalLength(Flower flower) {
        return flower.getSepalLength();
    }

    public static double calcSepalWidth(Flower flower) {
        return flower.getSepalWidth();
    }

    public static double calcPetalLength(Flower flower) {
        return flower.getPetalLength();
    }

    public static double calcPetalWidth(Flower flower) {
        return flower.getPetalWidth();
    }
}