package model;

import java.util.List;

public interface MachineInterface {
    public void addToy(String toyName, int toysCount, int toyWinning);
    List<Toy> getAllToys();
    public void winToy();
    public void deleteToy(String toyName, int toysCount, int toyWeight);
}
