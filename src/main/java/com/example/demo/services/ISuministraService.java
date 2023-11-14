package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Suministra;


public interface ISuministraService {
	
		//Listar todos
		public List<Suministra> listarSuministros();
		
		//Listar por id
		public Suministra suministraXID(Integer id); 
		
		//Guardar
		public Suministra guardarSuministra(Suministra suministra);
		
		//Actualizar
		public Suministra actualizarSuministra(Suministra suministra);
		
		//Eliminar
		public void eliminarSuministra(Integer id);

}