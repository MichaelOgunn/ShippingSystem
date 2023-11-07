import model.Port;

import static org.junit.jupiter.api.Assertions.*;

class PortTest {

    @org.junit.jupiter.api.Test
    void getPortName() {
        Port port = new Port("fj", "fj", "fj");
        port.setPortName("portName");
        assertEquals("portName", port.getPortName());
    }

    @org.junit.jupiter.api.Test
    void setPortName() {
    }

    @org.junit.jupiter.api.Test
    void getPortCode() {
    }

    @org.junit.jupiter.api.Test
    void setPortCode() {
    }

    @org.junit.jupiter.api.Test
    void getPortCountry() {
    }

    @org.junit.jupiter.api.Test
    void setPortCountry() {
    }

    @org.junit.jupiter.api.Test
    void addContainerToOnShore() {
    }

    @org.junit.jupiter.api.Test
    void removeContainerFromOnShore() {
    }
}