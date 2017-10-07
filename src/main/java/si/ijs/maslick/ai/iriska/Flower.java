package si.ijs.maslick.ai.iriska;

public class Flower {

    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;

    // Constructors
    public Flower() {
    }

    public Flower(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
    }

    // Getters, setters
    public double getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(double sepalLength) {
        this.sepalLength = sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(double sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(double petalLength) {
        this.petalLength = petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(double petalWidth) {
        this.petalWidth = petalWidth;
    }

    // Builder
    public static FlowerBuilder builder() {
        return new FlowerBuilder();
    }

    public static class FlowerBuilder {
        private double sepalLength;
        private double sepalWidth;
        private double petalLength;
        private double petalWidth;

        FlowerBuilder() {
        }

        public FlowerBuilder setSepalLength(double sepalLength) {
            this.sepalLength = sepalLength;
            return this;
        }

        public FlowerBuilder setSepalWidth(double sepalWidth) {
            this.sepalWidth = sepalWidth;
            return this;
        }

        public FlowerBuilder setPetalLength(double petalLength) {
            this.petalLength = petalLength;
            return this;
        }

        public FlowerBuilder setPetalWidth(double petalWidth) {
            this.petalWidth = petalWidth;
            return this;
        }

        public Flower build() {
            return new Flower(this.sepalLength, this.sepalWidth, this.petalLength, this.petalWidth);
        }
    }
}