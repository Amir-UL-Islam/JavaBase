package com.aiokleo.interface_inheritance_kotlin;

interface Human {
    void EveryThing();
}
interface Animal extends Human{
    void Nothing();
    @Override
    default void EveryThing(){
        System.out.println("EveryThing from Human (Inherited from Human)");
    }

}
class HumanAnimal implements Animal{
    @Override
    public void EveryThing() {
        System.out.println("EveryThing from Animal");
    }
    @Override
    public void Nothing() {
        System.out.println("Nothing");
    }

    public static void main(String[] args) {
        HumanAnimal humanAnimal = new HumanAnimal();
        humanAnimal.EveryThing();
        humanAnimal.Nothing();
    }
}