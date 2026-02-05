package io.topic.singleton;
// SingleTon mean allowing A CLASS to CREATE 1 INSTANCE

public class Singleton {
    public static void main(String[] args) {
        SingletonClass anInstance = SingletonClass.getInstance();
        anInstance.showMessage();
        // I can't do
        // ```
        // ABC abcTwo = new ABC();
        // ```
        // BECAUSE ABC is a Private
        // SO I have to go with this

        SingletonClass anotherInstance = SingletonClass.getInstance();
        anotherInstance.showMessage();
        // Which will return the same Instance
    }
}

// STEPs of CREATing Singleton

class SingletonClass {

    // 1st STEP
    private volatile static SingletonClass instance; // Because the getInstance() is a Static Method to do abc OBJECT.
    // 2nd STEP

    private SingletonClass() {

        // Adding validation so that no Replication cannot create another instance of it
        //
        if (instance != null) {
            throw new IllegalAccessError("Already an instance exist.");
        }
    }

    ;

    // 3rd STEP
    public static SingletonClass getInstance() {
        System.out.println("Only 1 Instance is allowed");

        // Applying Thread Safety
        if (instance == null) {
            synchronized (SingletonClass.class) {

                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

    public Object readResolve() {
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone no support");

    }

    public void showMessage() {
        System.out.println("Singleton instance: " + this.hashCode());
    }

}
