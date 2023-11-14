package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Proveedor;


public interface IProveedorService {
	
		//Listar todos
		public List<Proveedor> listarProveedores();
		
		//Listar por id
		public Optional<Proveedor> getProveedorXID(String id); 
		
		//Guardar
		public Proveedor guardarProveedor(Proveedor proveedor);
		
		//Actualizar
		public Proveedor actualizarProveedor(Proveedor proveedor);
		
		//Eliminar
		public void eliminarProveedor(String id);

}