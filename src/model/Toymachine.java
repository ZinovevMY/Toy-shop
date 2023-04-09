package model;
import model.Toy;

import java.util.List;

public class Toymachine {
    private int toysCount;
    private List<Toy> toys;

    public Toymachine(int toysCount, List<Toy> toys) {
        this.toysCount = toysCount;
        this.toys = toys;
    }

    public void setToysCount(int toysCount) {
        this.toysCount = toysCount;
    }

    public int getToysCount() {
        return toysCount;
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void removeToy(Toy toy){
        for (Toy item: toys)
            if (toy.getToyId() == item.getToyId()){
                toys.remove(item);
                break;
            }
    }
}
