package backendclase26.dao;

import backendclase26.bd.BD;
import backendclase26.modelo.Odontologo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection=null;
        try {
            connection = BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("inset into odontologos (apellido, nombre, matricula) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,odontologo.getApellido());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getMatricula());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        Connection connection=null;
        Odontologo odontologo=null;
        try {
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("select * from odontologos where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                odontologo = new Odontologo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
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
        return odontologo;
    }

    @Override
    public Odontologo buscarXCriterio(String criterio) {
        Connection connection=null;
        Odontologo odontologo=null;
        try {
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("select * from odontologos where criterio=?");
            ps.setString(1, criterio);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                odontologo = new Odontologo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
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
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection= null;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("select * from odontologos");
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                odontologos.add(new Odontologo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
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
        return odontologos;
    }
}
