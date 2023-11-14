package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISuministraDAO;
import com.example.demo.dto.Suministra;

@Service
public class SuministraService implements ISuministraService{
	
	@Autowired
	ISuministraDAO iSuministraDAO;

		//Listar todos
		public List<Suministra> listarSuministros(){
			return iSuministraDAO.findAll();
		};
		
		//Listar por id
		public Suministra suministraXID(Integer id) {
			return iSuministraDAO.findById(id).get();
		}; 
		
		//Guardar
		public Suministra guardarSuministra(Suministra suministra) {
			return iSuministraDAO.save(suministra);
		};
		
		//Actualizar
		public Suministra actualizarSuministra(Suministra suministra) {
			return iSuministraDAO.save(suministra);
		};
		
		//Eliminar
		public void eliminarSuministra(Integer id) {
			iSuministraDAO.deleteById(id);
		}	

}