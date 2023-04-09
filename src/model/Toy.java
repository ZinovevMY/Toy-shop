package model;

public class Toy {

    private int toyId;
    private String toyName;
    private int toyQuantity;
    private int toyWinning;

    public Toy(int toyId, String toyName, int toyQuantity, int toyWinning){
        this.toyId = toyId;
        this.toyName = toyName;
        this.toyQuantity = toyQuantity;
        this.toyWinning = toyWinning;
    }

    public int getToyId() {
        return toyId;
    }

    public String getToyName() {
        return toyName;
    }

    public int getToyQuantity() {
        return toyQuantity;
    }

    public int getToyWinning() {
        return toyWinning;
    }

    public void setToyId(int toyId) {
        this.toyId = toyId;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public void setToyQuantity(int toyQuantity) {
        this.toyQuantity = toyQuantity;
    }

    public void setToyWinning(int toyWinning) {
        this.toyWinning = toyWinning;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "toyId=" + toyId +
                ", toyName='" + toyName + '\'' +
                ", toyQuantity=" + toyQuantity +
                ", toyWinning=" + toyWinning +
                '}';
    }
}
