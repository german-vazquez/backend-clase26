package backendclase26.controller;

import backendclase26.modelo.Odontologo;
import backendclase26.servicio.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public List<Odontologo> listarTodos() {
        return odontologoService.listarTodos();
    }

    @PostMapping
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardar(odontologo);
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologo(@PathVariable Integer id){
        return odontologoService.buscarXId(id);
    }
}

    /*
    private final OdontologoService odontologoService;
    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    @PostMapping
    public Odontologo registarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardar(odontologo);
    }
    @GetMapping
    public List<Odontologo> listarTodos(){
        return odontologoService.listarTodos();
    }
    @GetMapping("/{id}")
    public Odontologo buscarOdontologo(@PathVariable Integer id){
        return odontologoService.buscarXId(id);
    }
}
*/
