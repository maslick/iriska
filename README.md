# =iriska=
 * contains an Iris flower classification model
 * uses [Klassy](https://github.com/maslick/klassy) weka wrapper

See [this](https://en.wikipedia.org/wiki/Iris_flower_data_set) and [this article](https://www.ibm.com/developerworks/library/bd-javaweka/index.html) for more details

## Installation
 * Import ``iriska.jar`` into your project
 * Add Klassy as dependency
```
repositories {
    jcenter()
}
...
dependencies {    
    compile('com.maslick.ai:klassy:0.1.8')
}
```

## Usage
```java
Iris model = new Iris(new ContextLoader());
Flower flower = Flower.builder()
        .setSepalLength(5.57091678078844)
        .setPetalWidth(3.09644861465126)
        .setPetalLength(1.23725924762744)
        .setPetalWidth(0.113236009159561)
        .build();

String klass = model.classify(flower); // = setosa
```
