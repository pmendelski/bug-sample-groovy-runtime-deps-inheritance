# Bug sample project

Runtime java dependencies are not inherited by groovy test runtime.
Therefore if a library in defined as a compile dependency groovy test does not see it. 

Command `./gradlew clean build --stacktrace`
- [log file](./log.txt)
- [scan](https://gradle.com/s/nyzcfimlzxpxe) 

Compilations:
- `./gradlew compileTestJava` - Success
- `./gradlew compileTestGroovy` - Failure (java.lang.NoClassDefFoundError: com.coditory.sherlock.InMemoryDistributedLockStorage)

