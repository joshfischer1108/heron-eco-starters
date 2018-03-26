## Configuring Output Fields with Configuration Methods

This is an example of how to dynamically set output fields in your Java
code using a configuration method in ECO.

Run an example that uses a configuration method: 
```bash
$ heron submit local \
  target/eco-starters-1.0-SNAPSHOT-jar-with-dependencies.jar \
  com.twitter.heron.eco.Eco \
  --eco-config-file yaml/config-method.yaml
```

In the `ConfigurableFibonacciSpout` we can call any configuration method needed
for setting up a spout or a bolt.  In the below case ECO will look for a method named
`configureSpout` and call it with` "someString" as a parameter.  

```yaml
 - id: "configurable-spout"
    className: "org.apache.heron.eco.starters.ConfigurableFibonacciSpout"
    configMethods:
      - name: "configureSpout"
        args:
          - "someString"
```

The java equivalent to the above is:

 ```java
public void configureSpout(String fieldName) {
        this.fieldName = fieldName;
}
```

`args` is a list of arguments that should be passed to the `configMethod`.  If the config
method took two strings as arguments you would specify your YAML like below

```yaml
 - id: "configurable-spout"
    className: "org.apache.heron.eco.starters.ConfigurableFibonacciSpout"
    configMethods:
      - name: "configureSpout"
        args:
          - "someString"
          - "secondString"
```

The java equivalent to  the above is:

 ```java
public void configureSpout(String fieldName, String otherFieldName) {
        this.fieldName = fieldName;
        // Do something else with "otherFieldName"
}
```