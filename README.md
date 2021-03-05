# MetaAPI (JavaSDK)

MetaAPI is intended as a solution for developers 
who want to work with Metaverse API. MetaAPI (Java SDK) 
provide full wrapping of the Metaverse API.

## Summary

_For more information about the API visit the MetaverseAPI documentation._

1. [Introduction](#creating-an-api-instance)
2. [Actions](#actions)
3. [Entities](#entities)
4. [Download](#download)
5. [Documentation](#documentation)
6. [Help and Support](#help)
7. [Dependencies](#dependencies)

## Creating an API instance

The way to create the main instance is pretty simple. We need to call the Builder
and with our authentication method.

```java
MetaAPI metaAPI = MetaAPI.Builder.createBuilder()
            .withToken("<token>")
            .build();
```

### Actions

With actions, we handle the requests in different ways:
 
 - Callbacks
 - Promises
 - Sync

This three ways leave the pattern to the developer. This is intended 
to give the best experiences to any type of developers.



### Entities

Represents a callback or result of the MetaverseAPI. Entities will have available actions to
be used withing their data. \
_In this version of the SDK the entity is not updated after a callback or similar._

## Download

Latest Stable Version [Release](https://github.com/MyMetaverse/JavaSDK/releases/latest) 

#### Maven
```xml
<dependency>
    <groupId>io.mymetavese</groupId>
    <artifactId>metaapi</artifactId>
    <version>VERSION</version>
</dependency>
```
#### Gradle
```groovy
dependencies {
    compile 'io.mymetaverse:metaapi:VERSION'
}
```

## Documentation

Docs can be found HERE.

## Help

For general bugs and errors visit FAQ.
If you need any help visit our [Discord](https://discord.gg/TFGC4AxVTt).

## Dependencies

This SDK requires Java 8+. \
All dependencies are managed by Maven. \

- OkHttp 
- Project Lombok (For Development)
- Gson
- Jupiter JUnit (For Development)

