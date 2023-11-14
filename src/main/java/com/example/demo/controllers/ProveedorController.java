package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Proveedor;
import com.example.demo.services.ProveedorService;

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorService proveedorService;

	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedores() {
		return proveedorService.listarProveedores();
	}
	
	@GetMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> proveedorXID(@PathVariable(name = "id") String id) {
		Optional<Proveedor> proveedor = proveedorService.getProveedorXID(id);
		if (proveedor.isPresent()) {
			return ResponseEntity.ok(proveedor.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/proveedor")
	public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorService.guardarProveedor(proveedor);
	}
	
	@PutMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable(name = "id") String id, @RequestBody Proveedor proveedor) {

		Optional<Proveedor> proveedor_seleccionado = proveedorService.getProveedorXID(id);

	    if (proveedor_seleccionado.isPresent()) {
	    	Proveedor proveedor_existente = proveedor_seleccionado.get();
	    	 
	    	if (proveedor.getNombre() != null) {
	    		proveedor_existente.setNombre(proveedor.getNombre());
		        }

	        Proveedor proveedor_actualizado = proveedorService.actualizarProveedor(proveedor_existente);

	        return ResponseEntity.ok(proveedor_actualizado);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/proveedor/{id}")
	public ResponseEntity<Void> eliminarProveedor(@PathVariable(name = "id") String id) {
		Optional<Proveedor> proveedor = proveedorService.getProveedorXID(id);
		if (proveedor.isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
