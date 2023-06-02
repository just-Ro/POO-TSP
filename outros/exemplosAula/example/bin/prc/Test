package prc;

public class Test{
    public static void main(String[] args){
        RemoteControl rc = new RemoteControl();

        Light l = new Light();
        GarageDoor gd = new GarageDoor();

        ICommand tonl = new TurnOnLight(l);
        ICommand toffl = new TurnOffLight(l);
        ICommand ogd = new OpenGarageDoor(gd);
        ICommand cgd = new CloseGarageDoor(gd);

        rc.setCommand(0, tonl);
        rc.setCommand(1, toffl);
        rc.setCommand(2, ogd);
        rc.setCommand(3, cgd);

        rc.buttonPressed(2);
        rc.buttonPressed(0);
        rc.buttonPressed(3);
        rc.buttonPressed(0);
        rc.undo();
    }
}