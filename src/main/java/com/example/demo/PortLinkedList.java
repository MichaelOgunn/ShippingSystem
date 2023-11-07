//package com.example.demo;
//
//import model.Port;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class PortLinkedList {
//        private PortNode head;
//
//        public PortLinkedList() {
//            this.head = null;
//        }
//        public void add(Port port) {
//            PortNode newNode = new PortNode(port);
//            if (this.head == null) {
//                this.head = newNode;
//            } else {
//                PortNode current = this.head;
//                while (current.next!= null) {
//                    current = current.next;
//                }
//                current.next = newNode;
//            }
//            System.out.println("Port added");
//        }
//        // The `listPorts()` method is used to generate a string representation of all the ports in the linked list.
//        public String listPorts(){
//
//            PortNode current = head;
//            // `StringBuilder result = new StringBuilder();` is creating a new instance of the `StringBuilder` class and
//            // assigning it to the variable `result`.
//            StringBuilder result = new StringBuilder();
//            while (current!= null) {
//                // `result.append(current.getPort().getPortName())` is appending the name of the port to the `result`
//                // string. It is retrieving the port name by calling the `getPortName()` method on the `Port` object stored
//                // in the current `PortNode`. The `append()` method is used to concatenate the port name to the `result`
//                // string.
//                result.append(current.getPort().getPortName())
//                        .append(" (")
//                        .append(current.getPort().getPortCode())
//                        .append(")\n");
//
//                current = current.next;
//
//            }
//            return result.toString();
//
//
//    }
//    public void delete(Port port) {
//            PortNode current = this.head;
//            PortNode previous = null;
//            while (current!= null) {
//                if (current.getPort().getPortName().equals(port.getPortName())) {
//                    if (previous == null) {
//                        this.head = current.next;
//                    } else {
//                        previous.next = current.next;
//                    }
//                    // The `break;` statement is used to exit the loop immediately. In the given code, when a matching port
//                    // is found, the `break;` statement is used to exit the loop and stop iterating through the linked
//                    // list. This is because once the port is found and deleted, there is no need to continue searching for
//                    // additional occurrences of the port.
//                    break;
//                }
//                previous = current;
//                current = current.next;
//            }
//            System.out.println("Port deleted");
//    }
//
//    public PortNode findPortByName(String choiceOfPort) {
//            PortNode current = this.head;
//            while (current!= null) {
//                if (current.getPort().getPortName().equals(choiceOfPort)) {
//                    return current;
//                }
//                current = current.next;
//            }
//            return null;
//    }
//
//    /**
//     * The function getAllPortNames() returns a list of all port names.
//     *
//     * @return The return type of the method is `List<String>`.
//     */
//    public List<String> getAllPortNames() {
//        List<String> portNames = new LinkedList<>();
//        PortNode current = head;
//        while (current != null) {
//            portNames.add(current.getPort().getPortName());
//            current = current.next;
//        }
//        return portNames;
//    }
//}
