package backendclase26.dao;

import backendclase26.bd.BD;
import backendclase26.modelo.Domicilio;
import backendclase26.modelo.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente>{
    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection=null;
        try {
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            domicilioDAOH2.guardar(paciente.getDomicilio());
            connection= BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("insert into pacientes (apellido, nombre, email, dni, fecha, domicilio_id) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getApellido());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getEmail());
            ps.setInt(4, paciente.getDni());
            ps.setDate(5, Date.valueOf(paciente.getFecha()));
            ps.setInt(6, paciente.getDomicilio().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                paciente.setId(rs.getInt(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        Connection connection=null;
        Paciente paciente = null;
        Domicilio domicilio;
        try {
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("select * from pacientes where id=?");
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                domicilio=domicilioDAOH2.buscar(rs.getInt(7));
                paciente=new Paciente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        domicilio
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public Paciente buscarXCriterio(String criterio) {
        Connection connection=null;
        Paciente paciente = null;
        Domicilio domicilio=null;
        try {
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("select * from pacientes where criterio=?");
            ps.setString(1,criterio);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                domicilio = domicilioDAOH2.buscar(rs.getInt(7));
                paciente = new Paciente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        domicilio
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public List<Paciente> listarTodos() {
        Connection connection=null;
        List<Paciente> pacientes = new ArrayList<>();
        Domicilio domicilio=null;
        try {
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            connection=BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from pacientes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                domicilio = domicilioDAOH2.buscar(rs.getInt(7));
                pacientes.add(new Paciente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        domicilio
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return pacientes;
    }
}
