## Configuring Output Fields with Configuration Methods

This is an example of how to dynamically set output fields in your Java
code using a configuration method in ECO.

Run an example that uses a configuration method: 
```bash
$ heron submit local \
  target/eco-starters-1.0-SNAPSHOT-jar-with-dependencies.jar \
  com.twitter.heron.eco.Eco \
  --eco-config-file src/main/resources/config-method.yaml
```