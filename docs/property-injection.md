## Configuring Output Fields with Property Injection

Run an example that uses constructor injection: 
```bash
$ heron submit local \
  target/eco-starters-1.0-SNAPSHOT-jar-with-dependencies.jar \
  com.twitter.heron.eco.Eco \
  --eco-config-file src/main/resources/constructor-injection.yaml
```


Run an example that uses setter injection: 
```bash
$ heron submit local \
  target/eco-starters-1.0-SNAPSHOT-jar-with-dependencies.jar \
  com.twitter.heron.eco.Eco \
  --eco-config-file src/main/resources/setter-injection.yaml
```


Run an example that uses configuration method: 
```bash
$ heron submit local \
  target/eco-starters-1.0-SNAPSHOT-jar-with-dependencies.jar \
  com.twitter.heron.eco.Eco \
  --eco-config-file src/main/resources/config-method.yaml
```