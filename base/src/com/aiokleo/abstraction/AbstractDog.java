package com.aiokleo.abstraction;

public class AbstractDog extends Animals{

    @Override
    public void makeNoise() {
        System.out.println(this.ILove);
        System.out.print("Say Vau..Vau...!");

    }
    @Override
    public void EveryThing(){
        System.out.println("\n"+"Yes!");
    }

}
