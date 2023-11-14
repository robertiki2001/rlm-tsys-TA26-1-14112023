package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Suministra;
import com.example.demo.services.SuministraService;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraService suministraService;

	@GetMapping("/suministros")
	public List<Suministra> listarSuministros() {
		return suministraService.listarSuministros();
	}

	@GetMapping("/suministra/{id}")
	public Suministra suministraXID(@PathVariable(name = "id") Integer id) {
		return suministraService.suministraXID(id);
	}

	@PostMapping("/suministra")
	public Suministra guardarSuministra(@RequestBody Suministra suministra) {
		return suministraService.guardarSuministra(suministra);
	}

	@PutMapping("/suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name = "id") Integer id, @RequestBody Suministra suministra) {

		Suministra suministra_seleccionado = suministraService.suministraXID(id);
		Suministra suministra_actualizado = new Suministra();

		suministra_seleccionado.setPieza(suministra.getPieza());
		suministra_seleccionado.setProveedor(suministra.getProveedor());
		suministra_seleccionado.setPrecio(suministra.getPrecio());

		suministra_actualizado = suministraService.actualizarSuministra(suministra_seleccionado);

		return suministra_actualizado;
	}

	@DeleteMapping("/suministra/{id}")
	public void eliminarSuministra(@PathVariable Integer id) {
		suministraService.eliminarSuministra(id);
	}

}
