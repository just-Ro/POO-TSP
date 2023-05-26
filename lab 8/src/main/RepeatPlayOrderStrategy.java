package main;

import java.util.List;

public class RepeatPlayOrderStrategy implements IPlayOrderStrategy{
    public List<String> getOrder(List<String> playlist){

        return playlist;
    }
}