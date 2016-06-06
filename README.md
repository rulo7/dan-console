# dan-console
Console tools to generate code into domain and data layers in an AndroidApplication

# Usage
1. Add the following lines to your root build.gradle:

```groovy
repositories {
    ...
    maven {
        url "http://dl.bintray.com/racobos/maven"    
    }
}
```

```groovy
dependencies {
    ...
    classpath 'com.racobos:danPlugin:1.0.1'
}
```

```groovy
apply plugin: 'dan-plugin'
```
2. Add your app name and your package name in the gradle.properties

```
# App Name
appName = Suplain

# Package syntax
packageSyntax = com.suplain.app
```

3. Generate your own entities

```
    ./gradlew danGenerateEntity -Pentities=<entity1>,<entity2>
```

4. Generate your UI view flows

```
    ./gradlew danGenerateUi -PuiName=<uiName>
```

5. Generate the views into the UI flow defined

```
 ./gradlew danGenerateView -PuiName=<uiName> -PviewName=<viewName>
```
