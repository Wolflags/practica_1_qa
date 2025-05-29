package org.example.entities;

import java.util.*;

public class Carrito {
    private final Map<String, ItemCarrito> items = new LinkedHashMap<>();

    public void agregarProducto(Producto p, int cantidad) {
        if (items.containsKey(p.getId())) {
            ItemCarrito existente = items.get(p.getId());
            existente.setCantidad(existente.getCantidad() + cantidad);
        } else {
            items.put(p.getId(), new ItemCarrito(p, cantidad));
        }
    }

    public void eliminarProducto(String productoId) {
        items.remove(productoId);
    }

    public void modificarCantidad(String productoId, int nuevaCantidad) {
        ItemCarrito item = items.get(productoId);
        if (item == null) throw new NoSuchElementException("Producto no en carrito");
        item.setCantidad(nuevaCantidad);
    }

    public double calcularTotal() {
        return items.values().stream()
                .mapToDouble(ItemCarrito::subtotal)
                .sum();
    }

    public Collection<ItemCarrito> getItems() {
        return Collections.unmodifiableCollection(items.values());
    }
}