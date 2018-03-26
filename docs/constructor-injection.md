## Configuring Output Fields with Constructor Injection

This is an example of how to dynamically set output fields in your Java
code using constructor injection in ECO.

Run an example that uses constructor injection: 
```bash
$ heron submit local \
  target/eco-starters-1.0-SNAPSHOT-jar-with-dependencies.jar \
  com.twitter.heron.eco.Eco \
  --eco-config-file src/main/resources/constructor-injection.yaml
```
In this ECO config file in the spout is set to accept a single `String` argument and has a value of `"number"`. 

```yaml
- id: "configurable-spout"
    className: "org.apache.heron.eco.starters.ConfigurableFibonacciSpout"
    constructorArgs:
      - "number"
    parallelism: 1
```

This YAML spec is equivalent to the Java constructor below:

```java
public ConfigurableFibonacciSpout(String fieldName) {
        this.fieldName = fieldName;
}
```

If a constructor has more than one argument you would specify them in the 
order they are expected in the YAML list. So in the case that the `ConfigurableFibonacciSpout`
had a constructor that accepted a `String` and an `int`  the YAML spec would be configured like so.

```yaml
- id: "configurable-spout"
    className: "org.apache.heron.eco.starters.ConfigurableFibonacciSpout"
    constructorArgs:
      - "number"
      - 123
    parallelism: 1
```

This YAML spec is equivalent to the Java constructor below:

```java
 public ConfigurableFibonacciSpout(String fieldName, int anInt) {
        this.fieldName = fieldName;
        this.anInt = anInt;
}
```