package carrito;

import org.example.entities.Carrito;
import org.example.entities.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarritoTest {

    private Carrito carrito;
    private Producto p1, p2;

    @BeforeEach
    void setUp() {
        carrito = new Carrito();
        p1 = new Producto("P01", "Lapicero", 1.50);
        p2 = new Producto("P02", "Cuaderno", 2.00);
    }

    @Test
    void agregarYCalcularTotal() {
        carrito.agregarProducto(p1, 2);
        carrito.agregarProducto(p2, 1);
        assertEquals(1.50*2 + 2.00, carrito.calcularTotal());
    }

    @Test
    void eliminarProducto() {
        carrito.agregarProducto(p1, 1);
        carrito.eliminarProducto("P01");
        assertEquals(0, carrito.calcularTotal());
    }

    @Test
    void modificarCantidadYTotal() {
        carrito.agregarProducto(p2, 5);
        carrito.modificarCantidad("P02", 2);
        assertEquals(4.00, carrito.calcularTotal());
    }

    @Test
    void modificarCantidadProductoNoExistenteLanzaError() {
        assertThrows(NoSuchElementException.class,
                () -> carrito.modificarCantidad("X99", 1));
    }
}