package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Pieza;


public interface IPiezaService {
	
		//Listar todos
		public List<Pieza> listarPiezas();
		
		//Listar por id
		public Pieza piezaXID(Integer id); 
		
		//Guardar
		public Pieza guardarPieza(Pieza pieza);
		
		//Actualizar
		public Pieza actualizarPieza(Pieza pieza);
		
		//Eliminar
		public void eliminarPieza(Integer id);

}