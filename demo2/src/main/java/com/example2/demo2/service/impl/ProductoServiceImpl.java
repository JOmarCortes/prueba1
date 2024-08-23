package com.example2.demo2.service.impl;

import com.example2.demo2.entity.Producto;
import com.example2.demo2.repository.ProductoRepository;
import com.example2.demo2.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto getProductoById(Long productoId) {
        Optional<Producto> optionalProducto = productoRepository.findById(productoId);
        return optionalProducto.get();
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto updateProducto(Producto producto) {
        Producto existingProducto = productoRepository.findById(producto.getId()).get();
        existingProducto.setNombre(producto.getNombre());
        existingProducto.setDescripcion(producto.getDescripcion());
        existingProducto.setPrecio(producto.getPrecio());
        existingProducto.setCantidadEnStock(producto.getCantidadEnStock());
        return productoRepository.save(existingProducto);
    }

    @Override
    public void deleteProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }
}
