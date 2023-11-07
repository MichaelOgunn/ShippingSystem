package com.example.demo;

import model.ContainerShip;

public class ContainerShipLinkedList {
    private ContainerShipNode head;

    public ContainerShipLinkedList() {
        this.head = null;
    }
    public void add(ContainerShip containerShip) {
        ContainerShipNode newNode = new ContainerShipNode(containerShip);
        if (this.head == null) {
            this.head = newNode;
        } else {
            ContainerShipNode current = this.head;
            while (current.next!= null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("ContainerShip added");
    }

}
