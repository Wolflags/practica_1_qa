package carrito;

import org.example.entities.ItemCarrito;
import org.example.entities.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemCarritoTest {

    // Prueba de creación de un ItemCarrito y calculo de subtotal
    @Test
    void subtotalCalculadoCorrectamente() {
        Producto p = new Producto("P02", "Cuaderno", 2.00);
        ItemCarrito it = new ItemCarrito(p, 3);
        assertEquals(6.00, it.subtotal());
    }

    // Prueba de cambio de cantidad a un numero invalido
    @Test
    void cambiarCantidadInvalidaLanzaError() {
        Producto p = new Producto("P03", "Goma", 0.50);
        ItemCarrito it = new ItemCarrito(p, 1);
        assertThrows(IllegalArgumentException.class, () -> it.setCantidad(0));
    }
}