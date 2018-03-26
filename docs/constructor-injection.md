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