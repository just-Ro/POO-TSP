package main;

public class Corporation extends StockHolder{
    private float value;

    public Corporation(String name, float value, float money){
        super(name, money);
        this.value = value;
    }

    public Share createShare(int amount){
        Share share = new Share(this, this, amount);
        super.AddShare(share);
        Market.putInMarket(share);
        return share;
    }


    public float getValue(){
        return this.value;
    }
}