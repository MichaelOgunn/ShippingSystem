package model;

import model.Container;
import model.Port;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortTest {

    @Test
    void getPortName() {
        Port port = new Port("fj", "fj", "fj");
        port.setPortName("portName");
        assertEquals("portName", port.getPortName());
    }

    @Test
    void setPortName() {
        Port port = new Port("waterford", "122", "ireland");
        port.setPortName("portName");
        assertEquals("portName", port.getPortName());
    }

    @org.junit.jupiter.api.Test
    void getPortCode() {
        Port port = new Port("waterford", "122", "ireland");
        assertEquals("122", port.getPortCode());
    }

    @org.junit.jupiter.api.Test
    void setPortCode() {
        Port port = new Port("waterford", "122", "ireland");
        port.setPortCode("internationalPortCode");
        assertEquals("internationalPortCode", port.getPortCode());

    }

    @org.junit.jupiter.api.Test
    void getPortCountry() {
        Port port = new Port("waterford", "122", "ireland");
        assertEquals("ireland", port.getPortCountry());
    }

    @org.junit.jupiter.api.Test
    void setPortCountry() {
        Port port = new Port("waterford", "122", "ireland");
        port.setPortCountry("country");
        assertEquals("country", port.getPortCountry());
    }

    @org.junit.jupiter.api.Test
    void addContainerToOnShore() {
        Port port = new Port("waterford", "122", "ireland");
        Container container = new Container("211",22);
        port.addContainerOnShore(container);
        assertTrue(port.getContainersOnShore().contains(container));
    }

    @org.junit.jupiter.api.Test
    void removeContainerFromOnShore() {
        Port port = new Port("waterford", "122", "ireland");
        Container container = new Container("211",22);
        port.addContainerOnShore(container);
        port.removeContainerFromOnShore(container);
        assertFalse(port.getContainersOnShore().contains(container));
    }
}