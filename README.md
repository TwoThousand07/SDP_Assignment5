# Strategy Navigation

Yerzhan Aitimov

A small route planner in Java that demonstrates the Strategy pattern. Navigator builds a route using a strategy (car, walk, bicycle, public transport), and the strategy can be switched at runtime.

Requires JDK 17 and Maven.

## Run

```
mvn clean package
java -cp target/classes kz.aitu.navigation.Main
```

## Test

```
mvn test
```

## Add a new strategy

Create a class in the strategy package that implements RouteStrategy, then pass it to navigator.setStrategy(...) in Main.
