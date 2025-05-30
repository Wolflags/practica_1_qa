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


    // Preparación de datos antes de cada prueba
    @BeforeEach
    void setUp() {
        carrito = new Carrito();
        p1 = new Producto("P01", "Lapicero", 1.50);
        p2 = new Producto("P02", "Cuaderno", 2.00);
    }

    // Prueba de agregar un producto al carrito
    @Test
    void agregarYCalcularTotal() {
        carrito.agregarProducto(p1, 2);
        carrito.agregarProducto(p2, 1);
        assertEquals(1.50*2 + 2.00, carrito.calcularTotal());
    }

    // Prueba de eliminar un producto
    @Test
    void eliminarProducto() {
        carrito.agregarProducto(p1, 1);
        carrito.eliminarProducto("P01");
        assertEquals(0, carrito.calcularTotal());
    }

    // Prueba de modificar cantidad de un producto
    @Test
    void modificarCantidadYTotal() {
        carrito.agregarProducto(p2, 5);
        carrito.modificarCantidad("P02", 2);
        assertEquals(4.00, carrito.calcularTotal());
    }

    // Prueba de modificar cantidad de un producto no existente
    @Test
    void modificarCantidadProductoNoExistenteLanzaError() {
        assertThrows(NoSuchElementException.class,
                () -> carrito.modificarCantidad("X99", 1));
    }
}