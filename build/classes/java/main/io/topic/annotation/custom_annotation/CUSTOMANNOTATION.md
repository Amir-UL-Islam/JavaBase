>## Creating Annotation
- Create a Interface with @ sign
```java
class @interface Stater{
    
}
```
- To Customize Annotation We need Annotation
  - ```@Target("Which kind of java Element This Annotation Valid to Used on.") ```
  - **Element Type** Like ```Class, Method, Object```
    - ```ElementType.TYPE``` this will Work for Classes and ```ElementType.METHOD``` will work for Methods
  - You Should include all ```ElementTypes``` into ```{}``` for multiple ```Element```
 

>### ```Retention Policy```
#### A retention policy determines at what point an annotation is discarded.
1. ```SOURCE```: annotation retained only in the source file and is discarded
          during compilation. Discard during the compile time. These annotations don't make any sense after the compilation has completed, so they aren't written to the bytecode. **Example:** ```@Override```, ```@SuppressWarnings```
2. ```CLASS```: annotation stored in the .class file during compilation,
         not available in the run time.
3. ```RUNTIME```: annotation stored in the .class file and available in the run time. Also Do not discard. The annotation should be available for reflection at runtime. **Example:** ```@Deprecated```

