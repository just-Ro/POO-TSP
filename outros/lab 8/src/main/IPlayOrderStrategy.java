package main;
import java.util.List;

interface IPlayOrderStrategy{
    public List<String> getOrder(List<String> playlist);
}