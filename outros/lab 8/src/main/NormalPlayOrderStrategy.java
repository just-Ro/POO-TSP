package main;

import java.util.List;

public class NormalPlayOrderStrategy implements IPlayOrderStrategy{
    public List<String> getOrder(List<String> playlist){

        return playlist;
    }
}
