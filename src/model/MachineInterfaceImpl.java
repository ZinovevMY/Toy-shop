package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MachineInterfaceImpl implements MachineInterface{

    private Toymachine toymachine = new Toymachine();
    private Toymapper toyMapper = new Toymapper();
    private FileOperations fileOperations;

    public MachineInterfaceImpl(FileOperations fileOperations){
        this.fileOperations = fileOperations;
    }

    @Override
    public void addToy(String toyName, int toysCount) {
        if (toysCount > 0){
            for (int i = 0; i < toysCount; i++){
                toymachine.addToy(new Toy(toymachine.getLastToyID(), toyName, 1, getToyWinning()));
            }
            List<String> allToys = new ArrayList<>();
            for (Toy item: toymachine.getToys()){
                allToys.add(toyMapper.saveMapToy(item));
            }
            fileOperations.putAllToys(allToys);
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
        List<Toy> toys = getAllToys();
        List<String> allToys = new ArrayList<>();
        int maxWin = 0;
        int toyId = 0;
        if (!toys.isEmpty()){
            for (Toy item: toys){
                if (item.getToyWinning() > maxWin){
                    maxWin = item.getToyWinning();
                    toyId = item.getToyId();
                }
            }
            for (Toy item: toys){
                if (toyId == item.getToyId()){
                    System.out.println("Поздравляем! Вы выиграли " + item.getToyName() + "!");
                }
                else {
                    allToys.add(toyMapper.saveMapToy(item));
                }
            }
            fileOperations.putAllToys(allToys);
        }
    }

    @Override
    public void removeToys() {
        fileOperations.removeToys();
    }

    private int getToyWinning(){
        int min = 1;
        int max = 100;
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    @Override
    public void viewToys() {
        List<Toy> allToys = getAllToys();
        Map<String, Integer> toys = toymachine.toysCalculate(allToys);
        if (!toys.isEmpty()){
            System.out.println("В автомате лежат:");
            for (Map.Entry<String, Integer> entry: toys.entrySet()){
                System.out.println(entry.getKey() + " - " + entry.getValue() + " шт.");
            }

        }
        else {
            System.out.println("Автомат пуст!");
        }
    }
}
