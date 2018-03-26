## Configuring Output Fields with Setter Injection

This is an example of how to dynamically set output fields in your Java
code using setter injection in ECO.

Run an example that uses setter injection: 
```bash
$ heron submit local \
  target/eco-starters-1.0-SNAPSHOT-jar-with-dependencies.jar \
  com.twitter.heron.eco.Eco \
  --eco-config-file src/main/resources/setter-injection.yaml
```