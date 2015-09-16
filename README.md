# AndroidContextHolder
获取应用context

## Import
[JitPack](https://jitpack.io/)

Add it in your project's build.gradle at the end of repositories:

```gradle
repositories {
  // ...
  maven { url "https://jitpack.io" }
}
```

Step 2. Add the dependency in the form

```gradle
dependencies {
  compile 'com.github.vilyever:AndroidContextHolder:1.0.2'
}
```

## Usage
```java

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        VDContextHolder.initial(this); // initial
    }
}

VDContextHolder.getContext(); // then call this anywhere

```

## License
[Apache License Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)

