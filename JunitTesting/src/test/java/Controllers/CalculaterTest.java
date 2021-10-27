package Controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculaterTest {

    @Test
    void add() {
        assertEquals(7, Calculater.add(3,4));
    }

    @Test
    void subtract() {
        assertEquals(1, Calculater.subtract(10, 9));
    }

    @Test
    void multiply() {
        assertEquals(35, Calculater.multiply(5,7));
    }

    @Test
    void divide() {
        assertEquals(3, Calculater.divide(15,5));
    }
}