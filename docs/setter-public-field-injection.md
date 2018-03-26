## Configuring Output Fields with Setter & Public Field Injection

This is an example of how to dynamically set output fields in your Java
code using setter and public field injection in ECO.

Run an example that uses setter injection: 
```bash
$ heron submit local \
  target/eco-starters-1.0-SNAPSHOT-jar-with-dependencies.jar \
  com.twitter.heron.eco.Eco \
  --eco-config-file yaml/setter-public-field-injection.yaml
```

You can also use ECO to set properties via setter methods.  In the below YAML spec ECO
will look for a setter named `setFieldName`.  If found it will use it to set the field.
The `name` value should match the field name in the Java class and have standard Java naming convention for setters and getters. 
If no setter is found ECO will look for a public field with a matching name.   

```yaml
  - id: "configurable-spout"
    className: "org.apache.heron.eco.starters.ConfigurableFibonacciSpout"
    properties:
      - name: "fieldName"
        value: "number"
    parallelism: 1
```

In the below example `ConfigurableSystemOutBolt` does not have a setter method for 
`"someFloat"`.  Since it is a public field in the class ECO will still be able to set it.

```yaml
- id: "print-bolt"
    className: "org.apache.heron.eco.starters.ConfigurableSystemOutBolt"
    properties:
      - name: "someFloat"
        value: 123.45
    parallelism: 1
```
