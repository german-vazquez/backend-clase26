package backendclase26.controller;

import backendclase26.modelo.Odontologo;
import backendclase26.modelo.Paciente;
import backendclase26.servicio.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }
    @GetMapping
    public List<Paciente> listarTodos(){
        return pacienteService.listarTodos();
    }
}
