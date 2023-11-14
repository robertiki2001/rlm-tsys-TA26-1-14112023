package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezaDAO;
import com.example.demo.dto.Pieza;

@Service
public class PiezaService implements IPiezaService{
	
	@Autowired
	IPiezaDAO iPiezaDAO;

		//Listar todos
		public List<Pieza> listarPiezas(){
			return iPiezaDAO.findAll();
		};
		
		//Listar por id
		public Pieza piezaXID(Integer id) {
			return iPiezaDAO.findById(id).get();
		}; 
		
		//Guardar
		public Pieza guardarPieza(Pieza pieza) {
			return iPiezaDAO.save(pieza);
		};
		
		//Actualizar
		public Pieza actualizarPieza(Pieza pieza) {
			return iPiezaDAO.save(pieza);
		};
		
		//Eliminar
		public void eliminarPieza(Integer id) {
			iPiezaDAO.deleteById(id);
		}		

}