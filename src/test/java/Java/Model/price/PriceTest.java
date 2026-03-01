package Java.Model.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceTest {

    @Test
    public void testArithmeticAndComparison() throws InvalidPriceException {
        Price p100 = new Price(10000); // $100.00
        Price p50 = new Price(5000); // $50.00

        assertEquals(new Price(15000), p100.add(p50));
        assertEquals(new Price(5000), p100.subtract(p50));
        assertEquals(new Price(20000), p100.multiply(2));

        assertTrue(p100.greaterThan(p50));
        assertTrue(p50.lessThan(p100));
        assertTrue(p100.greaterOrEqual(p100));
        assertTrue(p50.lessOrEqual(p100));
    }

    @Test
    public void testNullInputsThrow() {
        Price p = new Price(100);
        assertThrows(InvalidPriceException.class, () -> p.add(null));
        assertThrows(InvalidPriceException.class, () -> p.subtract(null));
        assertThrows(InvalidPriceException.class, () -> p.greaterThan(null));
        assertThrows(InvalidPriceException.class, () -> p.lessThan(null));
    }

    @Test
    public void testToStringAndEquals() {
        Price p = new Price(12345); // $123.45
        assertEquals("$123.45", p.toString());

        Price neg = new Price(-12345);
        assertEquals("$-123.45", neg.toString());

        assertEquals(new Price(100), new Price(100));
        assertNotEquals(new Price(100), new Price(101));
    }
}