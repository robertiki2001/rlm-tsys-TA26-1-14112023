package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedorDAO;
import com.example.demo.dto.Proveedor;

@Service
public class ProveedorService implements IProveedorService{
	
	@Autowired
	IProveedorDAO iProveedorDAO;

		//Listar todos
		public List<Proveedor> listarProveedores(){
			return iProveedorDAO.findAll();
		};
			
		//Listar por id
		public Optional<Proveedor> getProveedorXID(String id) {
		    return iProveedorDAO.findById(id);
		}
		
		//Guardar
		public Proveedor guardarProveedor(Proveedor proveedor) {
			return iProveedorDAO.save(proveedor);
		};
		
		//Actualizar
		public Proveedor actualizarProveedor(Proveedor proveedor) {
			return iProveedorDAO.save(proveedor);
		};
		
		//Eliminar
		public void eliminarProveedor(String id) {
			iProveedorDAO.deleteById(id);
		}		

}