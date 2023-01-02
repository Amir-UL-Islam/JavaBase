### Spring Container
#### Container is Created When ```ConfigurableApplicationContext``` is Called.
![Spring_Container](/home/aiokleo/IdeaProjects/demo-boot/imageNotes/springContainer.png)
- #### The Object in Side the Spring Container is Called ```Spring Bean```.
>- #### And There are ```Scops```.
>   - ```Singleton```
>       - Are Automatically Created & Only 1 Object.
>   - ```Prototype``` also have ```Request``` and ```Session```
>       - When the User Specifies 

By Default the Constructors are Singleton. If I want the Constructors to Prototype. I have to Specify with ```@Scope(value="prototype)``` this Annotation. Now I can call the Constructor as many as I want to.