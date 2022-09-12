package backendclase26.bd;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
    private static final String DriverH2="org.h2.Driver";
    private static final String UrlBD="jdbc:h2:~/clase26";
    private static final String User="sa";
    private static final String Pass="";
    private static final String FileSql=";init=runscript from 'create.sql'";

    public static Connection getConnection() throws Exception {
        Class.forName(DriverH2);
        return DriverManager.getConnection(UrlBD,User,Pass);
    }
    public static void crearTablas(){
        Connection connection=null;
        try{
            Class.forName(DriverH2);
            connection=DriverManager.getConnection(UrlBD+FileSql,User,Pass);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
