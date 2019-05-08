# Java Modules in Practice with Spring Boot

This project contains the source of the demo application used for my talk about migration your Spring Boot application to Java modules. What you're 
looking at right now are the sources of the application after migration. For the state of the application before migration, see the tag 
[before-migration](https://github.com/jaapcoomans/spring-boot-modules/tree/before-migration).

## Talk abstract

Java Modules have been around for a little while now and most of know deep inside that we need start doing something with them. Yet most developers 
are waiting for the momentum to take off. You've probably heard the theory a couple of times already, but putting it into practice sounds like mummy 
forcing you to eat your veggies. Actually I love my veggies, so I’ll gladly help you out here. In this session I will demonstrate how you can start 
using the power of modules in your own application. A Spring Boot application. Because despite the adoption in libraries is not yet great, you can 
already perfectly make your own application modular. I will guide you through a step-by-step approach to making your application modular. No magic or 
module-fu is required to achieve this result. Just everyday technologies we have at our disposal in the Java ecosystem. And as a bonus, it even works 
with Kotlin....

## Application details

The application essentially consists of 6 modules: `domain`, `persistence`, `rest-api`, `bgg-client`, `security` and 
`application`.
- `domain` is at the root of the dependency graph and essentially has no dependencies (outside the Java and Kotlin platform).
- `peristence` implements the persistence layer using Spring Data JPA and with PostgreSQL. Depends on `domain`.
- `rest-api` implements the REST API using Spring Web. Depends on `domain`
- `bgg-client` implements a client to the BoardGameGeek XML API using JAX-B and OpenFeign. Depends on `domain`.
- `security` implements the security configuration using Spring Security and jjwt. Has no internal dependencies.
- `application` is the module that pulls it all together. Depends on all other modules and Spring Boot. This is the main module. 

## Conferences
This talk was given at the following conferences:

| Conference      | Date        | Session details |
|-----------------|-------------|-----------------|
| Devoxx UK       | 10 May 2019 | [Session details](https://devoxxuk19.confinabox.com/talk/JOK-2933/Migrating_your_Spring_Boot_application_to_Java_Modules) |
| Spring I/O      | 16 May 2019 | [Session details](https://2019.springio.net/sessions/java-modules-in-practice-with-spring-boot ) |
| Oracle Code One | Sept 2019   | t.b.a.          |
