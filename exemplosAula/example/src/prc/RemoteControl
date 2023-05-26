package prc;

public class RemoteControl{
    private ICommand[] commands = new ICommand[4];
    private ICommand undocmd;

    public void setCommand(int i, ICommand cdm){
        commands[i] = cmd;
    }

    public void buttonPressed(int i){
        if(commands[i] != null){
            commands[i].execute();
        }
        undocmd = commands[i];
    }

    public void undo(){
        if(indocmd != null){
            undocmd.revert();
        }
    }
}