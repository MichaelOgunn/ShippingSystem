package model;

public class Pallet {
    public String goodsDescription;
    public double weight;
    public double size;
    public int quantity;
    public int  unitValue;

    public Pallet(String goodsDescription, double weight, double size, int quantity, int unitValue) {
        this.goodsDescription = goodsDescription;
        this.weight = weight;
        this.size = size;
        this.quantity = quantity;
        this.unitValue = unitValue;

    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(int unitValue) {
        this.unitValue = unitValue;
    }
    public String toString() {
        return "Pallet{" +
                "description='" + goodsDescription + '\'' +
                ", quantity=" + quantity +
                ", unitValue=" + unitValue +
                ", totalWeight=" + weight +
                ", totalSizeCubicFeet=" + size +
                '}';
    }
}
