package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MachineInterfaceImpl implements MachineInterface{

    private Toymachine toymachine = new Toymachine();
    private Toymapper toyMapper = new Toymapper();
    private FileOperations fileOperations;

    @Override
    public void addToy(String toyName, int toysCount, int toyWinning) {
        if (toysCount > 0){
            for (int i = 0; i < toysCount; i++){
                toymachine.addToy(new Toy(toymachine.getLastToyID(), toyName, 1, getToyWinning()));
            }

        }
    }

    @Override
    public List<Toy> getAllToys() {
        List<String> allToys = fileOperations.getAllToys();
        List<Toy> toys = new ArrayList<>();
        for (String toy: allToys){
            toys.add(toyMapper.loadMapToy(toy));
        }
        return toys;
    }

    @Override
    public void winToy() {

    }

    @Override
    public void deleteToy(String toyName, int toysCount, int toyWeight) {

    }

    private int getToyWinning(){
        int min = 1;
        int max = 100;
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
