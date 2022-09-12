package backendclase26.servicio;

import backendclase26.dao.IDao;
import backendclase26.dao.OdontologoDAOH2;
import backendclase26.modelo.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OdontologoService {
    IDao<Odontologo> odontologoIDao;

    public OdontologoService() {
        this.odontologoIDao = new OdontologoDAOH2();
    }
    public Odontologo guardar(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }
    public Odontologo buscarXId(Integer id){
        return odontologoIDao.buscar(id);
    }
    public Odontologo buscarXCriterio(String criterio){
        return odontologoIDao.buscarXCriterio(criterio);
    }
    public List<Odontologo> listarTodos(){
        return odontologoIDao.listarTodos();
    }

}
