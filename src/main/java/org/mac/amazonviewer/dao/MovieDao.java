package org.mac.amazonviewer.dao;
import org.mac.amazonviewer.db.IDBConnection;
import org.mac.amazonviewer.model.Movie;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.Integer.*;
import static org.mac.amazonviewer.db.DataBase.*;

//heredamos IDBConnection para hacer un manejo de Try With Resources para la conexion BD
public interface MovieDao extends IDBConnection {

    default Movie setMovieViewed(Movie movie){
        try (Connection connection = connectToDB()) {
            //establecemos con la conexión cambios en la BD aplica para Update e Insert
            Statement statement = connection.createStatement();
            String query = "INSERT INTO " + TVIEWED +
                    " ("+TVIEWED_IDMATERIAL+", " + TVIEWED_IDELEMENT + ", " + TVIEWED_IDUSUARIO+")" +
                    " VALUES(" + ID_TMATERIALS[0] + ", "+ movie.getId()+ ", "+TUSER_IDUSUARIO+")";

            if (statement.executeUpdate(query) > 0) {
                System.out.println("Se marcó en Visto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    default ArrayList<Movie> read()  {
        ArrayList<Movie> movies = new ArrayList<>();
        //haremos un try with resources para conexion apertura y cierra
        try (Connection connection = connectToDB())  {
            String query = "SELECT * FROM "+ TMOVIE;
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            //por medio de while traera cada registro de la tabla hasta finalizar
            while (rs.next())
            {
                // permite a getString(Accede Nombre del campo para traer el dato)
                Movie movie = new Movie(
                        rs.getString(TMOVIE_TITLE),
                        rs.getString(TMOVIE_GENRE),
                        rs.getString(TMOVIE_CREATOR),
                        //dado que el dato es prmitivo int y short haremos un wrapped para recibir
                        // un string para convertirlo en un entero
                        Integer.valueOf(rs.getString(TMOVIE_DURATION)),
                        Short.valueOf(rs.getString(TMOVIE_YEAR)));
                //Dado que el constructor movie no posee id se genera por fuera
                movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
                //activamos el getMovieViewed
                movie.setViewed(getMovieViewed(ps,connection, Integer.valueOf(rs.getString(TMOVIE_ID))));
                movies.add(movie);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    //el metodo tendra un prepared estame y connection y el id de la pelicula
    private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie){
        //para poder generar la actualización de si fue vista o no una serie o pelicula
        boolean viewed = false;
        String query = "SELECT * FROM " + TVIEWED + " WHERE "+ TVIEWED_IDMATERIAL + " = ?"
                + " AND " + TVIEWED_IDELEMENT + " = ?" + " AND " + TVIEWED_IDUSUARIO + " = ?";
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            //comohay signos de interrogación utilizamos el set para pasar los paramatros
            //el set va asociado al tipo de valor del campo
            preparedStatement.setInt(1,ID_TMATERIALS[0]);
            preparedStatement.setInt(2,id_movie);
            preparedStatement.setInt(3,TUSER_IDUSUARIO);

            rs = preparedStatement.executeQuery();
            //genera un valor para el caso qeu no sea falso  el viewed
            viewed = rs.next();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return viewed;
    }
}
