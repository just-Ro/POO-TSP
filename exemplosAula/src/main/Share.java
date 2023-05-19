package main;

public class Share{
    int quantity;
    StockHolder stockholder;
    Corporation corporation;

    public Share(StockHolder stockholder, Corporation corporation, int quantity){
        this.stockholder = stockholder;
        this.corporation = corporation;
        this.quantity = quantity;
    }
    
}