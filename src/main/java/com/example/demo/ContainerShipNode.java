package com.example.demo;

import model.ContainerShip;

public class ContainerShipNode {
    private ContainerShip containerShip;
    public ContainerShipNode next;

    public ContainerShipNode(ContainerShip containerShip) {
        this.containerShip = containerShip;
        this.next = null;
    }
    // getters and setters for containerShip and next
    public ContainerShip getContainerShip() {
        return containerShip;
    }
    public void setContainerShip(ContainerShip containerShip) {
        this.containerShip = containerShip;
    }
    public ContainerShipNode getNext() {
        return next;
    }
    public void setNext(ContainerShipNode next) {
        this.next = next;
    }
}
