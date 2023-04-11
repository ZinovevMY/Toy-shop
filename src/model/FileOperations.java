package model;

import java.util.List;

public interface FileOperations {
    void putAllToys(List<Toy> toys);
    List<Toy> getOutAllToys();
}
