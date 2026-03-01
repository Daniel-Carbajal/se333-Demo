package Java.Model.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceFactoryTest {

    @Test
    public void makePriceIntReturnsSingleton() {
        Price a = PriceFactory.makePrice(100);
        Price b = PriceFactory.makePrice(100);
        assertSame(a, b);
    }

    @Test
    public void makePriceStringParsesCorrectly() throws InvalidPriceException {
        Price p = PriceFactory.makePrice("123");
        assertEquals("$123.00", p.toString());

        Price p2 = PriceFactory.makePrice("$1.23");
        assertEquals("$1.23", p2.toString());
    }

    @Test
    public void invalidStringsThrow() {
        assertThrows(InvalidPriceException.class, () -> PriceFactory.makePrice("1.2.3"));
        assertThrows(InvalidPriceException.class, () -> PriceFactory.makePrice("12a.34"));
        assertThrows(InvalidPriceException.class, () -> PriceFactory.makePrice("12$34"));
        assertThrows(InvalidPriceException.class, () -> PriceFactory.makePrice("   "));
    }

}
