package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Pieza;
import com.example.demo.services.PiezaService;

@RestController
@RequestMapping("/api")
public class PiezaController {

	@Autowired
	PiezaService piezaService;

	@GetMapping("/piezas")
	public List<Pieza> listarPiezas() {
		return piezaService.listarPiezas();
	}

	@GetMapping("/pieza/{id}")
	public Pieza piezaXID(@PathVariable(name = "id") Integer id) {
		return piezaService.piezaXID(id);
	}

	@PostMapping("/pieza")
	public Pieza guardarPieza(@RequestBody Pieza pieza) {
		return piezaService.guardarPieza(pieza);
	}

	@PutMapping("/pieza/{id}")
	public Pieza actualizarPieza(@PathVariable(name = "id") Integer id, @RequestBody Pieza pieza) {

		Pieza pieza_seleccionado = piezaService.piezaXID(id);
		Pieza pieza_actualizado = new Pieza();

		pieza_seleccionado.setNombre(pieza.getNombre());

		pieza_actualizado = piezaService.actualizarPieza(pieza_seleccionado);

		return pieza_actualizado;
	}

	@DeleteMapping("/pieza/{id}")
	public void eliminarPieza(@PathVariable Integer id) {
		piezaService.eliminarPieza(id);
	}

}
