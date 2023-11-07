package model;

import com.example.demo.GenList;

public class Container {
    public String containerNumber;
    public int containerSize;
    public GenList<Pallet> pallets;


    public Container(String containerNumber, int containerSize) {
        this.containerNumber = containerNumber;
        this.containerSize = containerSize;
        this.pallets = new GenList<>();

    }
    public String getContainerNumber() {
        return containerNumber;
    }
    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }
    public int getContainerSize() {
        return containerSize;
    }
    public void setContainerSize(int containerSize) {
        this.containerSize = containerSize;
    }

    public void addPallet(Pallet pallet) {
        pallets.add(pallet);
    }

    // Remove a pallet from the container
    public void removePallet(Pallet pallet) {
        pallets.remove(pallet);
    }

    // Get the list of pallets in the container
    public GenList<Pallet> getPallets() {
        return pallets;
    }

}
