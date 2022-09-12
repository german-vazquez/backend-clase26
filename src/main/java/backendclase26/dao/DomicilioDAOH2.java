package backendclase26.dao;

import backendclase26.bd.BD;
import backendclase26.modelo.Domicilio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDAOH2 implements IDao<Domicilio> {
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("insert into domicilios (calle, numero, localidad, provincia)values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2,domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            while (rs.next()){
                domicilio.setId(rs.getInt(1));
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
        return domicilio;
    }

    @Override
    public Domicilio buscar(Integer id) {
        Connection connection=null;
        Domicilio domicilio=null;
        try {
            connection=BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from domicilios where id=?");
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                domicilio = new Domicilio(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));
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
        return domicilio;
    }

    @Override
    public Domicilio buscarXCriterio(String criterio) {
        Connection connection= null;
        Domicilio domicilio=null;
        try{
            connection =BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("select*from domicilios where provincia=?");
            ps.setString(1, criterio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                domicilio=new Domicilio(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)
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
        return domicilio;
    }

    @Override
    public List<Domicilio> listarTodos() {
        Connection connection=null;
        List<Domicilio> domicilios = new ArrayList<>();
        try {
            connection=BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from domicilios");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                domicilios.add(new Domicilio(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)
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
        return domicilios;
    }
}
