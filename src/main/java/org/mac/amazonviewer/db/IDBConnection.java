package org.mac.amazonviewer.db;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.mac.amazonviewer.db.DataBase.*;

public interface IDBConnection {
    //1. generamos inicialmente el Connection devuelve la instancia de la sesión
    default Connection connectToDB(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//se llama al driver como un paquete
            //uso mi driver manager para conexion a BBDD + traemos las variables estaticas
            connection = DriverManager.getConnection(URL+DB,USER,PASSWORD);
            //si se logro generar la conexión genere el mensaje que quedo ok
            if(connection != null){
                System.out.println("Se establecio la conexion");
            }



        } catch (Exception e) {
            e.printStackTrace();//refleja en caso de haber algun error se muestre
        }finally {
            return connection;
        }


    }
}
