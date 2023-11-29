package model;

import com.example.demo.GenList;

public class Container {
    public String containerNumber;
    public int containerSize;
    private GenList<Pallet> pallets;


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

    @Override
    public String toString() {
        return "Container{" +
                "containerNumber='" + containerNumber + '\'' +
                ", containerSize=" + containerSize +
                ", pallets=" + pallets +
                '}';
    }

    public double capacity() {
        double weight = 0.0;
        GenList<Pallet>.GenNode<Pallet> current = pallets.getFirst();
        while (current != null) {
            weight += current.getData().getWeight();

            current= current.getNext();
        }
        return containerSize - weight;
    }
    public boolean canAccomodate(Pallet pallet ) {
        return capacity() >= pallet.getWeight();
    }

    public double value() {
        double totalValue = 0.0;
        int totalQuantity = 0;
        GenList<Pallet>.GenNode<Pallet> current = pallets.getFirst();
        while (current != null) {
            totalValue += current.getData().getUnitValue() * current.getData().getQuantity();
            totalQuantity += current.getData().getQuantity();
            current = current.getNext();
        }
        if (totalQuantity == 0){
            return 0.0;
        }
        return totalValue / totalQuantity;
    }
}