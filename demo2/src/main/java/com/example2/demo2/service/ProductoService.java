package com.example2.demo2.service;

import com.example2.demo2.entity.Producto;

import java.util.List;

public interface ProductoService {
    Producto createProducto(Producto producto);

    Producto getProductoById(Long productoId);

    List<Producto> getAllProductos();

    Producto updateProducto(Producto producto);

    void deleteProducto(Long productoId);
}
