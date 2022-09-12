package backendclase26.servicio;

import backendclase26.dao.IDao;
import backendclase26.dao.PacienteDAOH2;
import backendclase26.modelo.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService() {
        this.pacienteIDao = new PacienteDAOH2();
    }
    public Paciente guardar(Paciente paciente){
        return pacienteIDao.guardar(paciente);
    }
    public Paciente buscarXId(Integer id){
        return pacienteIDao.buscar(id);
    }
    public Paciente buscarXCriterio(String criterio){
        return pacienteIDao.buscarXCriterio(criterio);
    }
    public List<Paciente> listarTodos(){
        return pacienteIDao.listarTodos();
    }
}
