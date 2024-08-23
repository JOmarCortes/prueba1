package com.example2.demo2.controller;

import com.example2.demo2.entity.Producto;
import com.example2.demo2.service.ProductoService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/productos")
public class ProductoController {

    private final ProductoService productoService;

    // build create Producto REST API
    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        Producto savedProducto = productoService.createProducto(producto);
        return new ResponseEntity<>(savedProducto, HttpStatus.CREATED);
    }

    // build get producto by id REST API
    // http://localhost:8080/api/productos/1
    @GetMapping("{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id") Long productoId){
        Producto producto = productoService.getProductoById(productoId);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    // Build Get All Productos REST API
    // http://localhost:8080/api/productos
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos(){
        List<Producto> productos = productoService.getAllProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Build Update Producto REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/productos/1
    public ResponseEntity<Producto> updateProducto(@PathVariable("id") Long productoId,
                                                   @RequestBody Producto producto){
        producto.setId(productoId);
        Producto updatedProducto = productoService.updateProducto(producto);
        return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
    }

    // Build Delete Producto REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable("id") Long productoId){
        productoService.deleteProducto(productoId);
        return new ResponseEntity<>("Producto successfully deleted!", HttpStatus.OK);
    }
}

