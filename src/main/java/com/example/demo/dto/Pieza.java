package com.example.demo.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table (name = "piezas")
public class Pieza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@OneToMany
    @JoinColumn(name="id")
	private List<Suministra> suministra;
	
	  public Pieza() {
	    }
	  
	    public Pieza(int id, String nombre, List<Suministra> suministra) {
	    	this.id = id;
	        this.nombre = nombre;	 
	        this.suministra = suministra;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
		public List<Suministra> getSuministra() {
			return suministra;
		}

		public void setSuministra(List<Suministra> suministra) {
			this.suministra = suministra;
		}


	   
}