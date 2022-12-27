### Creating Annotation
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
  