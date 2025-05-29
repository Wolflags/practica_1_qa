package carrito;

import org.example.entities.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductoTest {

    @Test
    void crearProductoYGetters() {
        Producto p = new Producto("P01", "Lapicero", 1.50);
        assertEquals("P01", p.getId());
        assertEquals("Lapicero", p.getNombre());
        assertEquals(1.50, p.getPrecioUnitario());
    }
}