package main;
import java.util.List;

public class Market{
    protected List<Share> shares;
    
    public Market(){

    }

    public void putInMarket(Share share){
        shares.add(share);
    }
    
    

    public void buy(StockHolder stockOwner, Corporation corporation, int amount){

    }
}