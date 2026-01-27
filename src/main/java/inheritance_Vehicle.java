class Vehicle{
    public void StartEngine() {
        System.out.println("Engine started");
    }
}
class car extends Vehicle{
    public void playmusic(){
        System.out.println("Playing FM radio");
    }
}

public class inheritance_Vehicle {
public static void main(String[] args){
    car myCar = new car ();
    myCar.StartEngine();
    myCar.playmusic();
}
}
