package prc;

public class TurnOnLight implements ICommand{
    Light light;

    public TurnOnLight(Light l){
        light = l;
    }

    @Override
    public void execute(){
        light.turnon();
    }

    @Override
    public void revert(){
        light.turnoff();
    }
}