
![logo](static/img/HeronTextLogo.png)

# Heron ECO Starters

This is a collection of examples and best practices on how to 
design and implement your Heron topologies using ECO API.

## What is ECO?  

ECO allows you to hook together spouts and bolts to assemble Heron Topologies without the need 
to recompile code to make changes in the configuration.

Check here here for more in depth documentation: https://twitter.github.io/heron/docs/developers/java/eco-api/

## What do these examples require for you to run?

You will need a Heron either running on your local or in a remote environment. Running locally is the easiest to get
going.  Read [this doc](https://twitter.github.io/heron/docs/getting-started/) for getting set up.  
All of these topologies are built with Maven and your typical Java setup.

## How To Build
All commands specified in this tutorial assume you
are working in macOS and have `heron` inluded in your `$PATH`.  Run the below in the root folder of the project.

```bash
$ mvn assembly:assembly
```

## Table of Contents

* [Constructor Injection](docs/constructor-injection.md)

* [Setter & Public Field Injection](docs/setter-public-field-injection.md)

* [Configuration Methods](docs/configuration-methods.md)


## This document and project will continually be updated. Check back soon. 

If you experience any issues while walking through the examples please file an issue in the repo.  I will get to it
as soon as I can.  

### Disclaimer !!!!

**It should be noted that even though the ECO definition topology files
are in the `yaml` directory this is not a suggestion or a requirement.**