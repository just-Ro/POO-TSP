package main;
import java.util.List;

public class StockHolder{

    protected List<Share> shares;

    String name;
    Float money;

    public StockHolder(String name, float money){
        this.name=name;
        this.money=money;
    }

    public float AddMoney(float moremoney){
        this.money=this.money + moremoney;
        return this.money;
    }

    public float RemoveMoney(float lessmoney){
        this.money=this.money - lessmoney;
        return this.money;
    }

    public void AddShare(Share newShare){
        shares.add(newShare);
    }

    public void RemoveShare(Share toremove){
        shares.remove(toremove);
    }

}
