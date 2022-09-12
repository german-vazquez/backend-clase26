package backendclase26.servicio;

import backendclase26.dao.DomicilioDAOH2;
import backendclase26.dao.IDao;
import backendclase26.modelo.Domicilio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DomicilioService {
    private IDao<Domicilio> domicilioIDao;

    public DomicilioService() {
        this.domicilioIDao = new DomicilioDAOH2();
    }
    public Domicilio guardar(Domicilio domicilio){
        return domicilioIDao.guardar(domicilio);
    };
    public Domicilio buscarXId (Integer id){
        return domicilioIDao.buscar(id);
    };
    public List<Domicilio> listarTodos(){
        return domicilioIDao.listarTodos();
    };
}
