package model;
import model.Toy;

import java.util.*;

public class Toymachine {

    private static final int TOYS_COUNT = 100;
    private int toysCount;
    private List<Toy> toys;

    public Toymachine() {
        this.toysCount = 0;
        this.toys = new ArrayList<Toy>();
    }


    public int getToysCount() {
        return toysCount;
    }

    public void addToy(Toy toy) {
        if (toysCount <= TOYS_COUNT){
            toysCount++;
            toys.add(toy);
        }else{
            System.out.println("Автомат полон игрушек!");
        }
    }

    public void removeToy(Toy toy){
        if (toysCount > 0){
            for (Toy item: toys){
                if (toy.getToyId() == item.getToyId()) {
                    toys.remove(item);
                    toysCount--;
                    break;
                }
            }
        }
        else {
            System.out.println("Автомат пуст!");
        }
    }

    private Map toysCalculate(List<Toy> toys){
          Map<String, Integer> res = new HashMap<>();
          int counter = 0;
          for (Toy item: toys){
              if (!res.containsKey(item.getToyName())){
                  res.put(item.getToyName(), 1);
              }
              else {
                  counter = res.get(item.getToyName()) + 1;
                  res.put(item.getToyName(), counter);
              }
          }
        return res;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
