package org.mac.amazonviewer.dao;

import org.mac.amazonviewer.db.IDBConnection;
import org.mac.amazonviewer.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.mac.amazonviewer.db.DataBase.*;

//heredamos IDBConnection para hacer un manejo de Try With Resources para la conexion BD
public interface MovieDao extends IDBConnection {

    default Movie setMovieViewed(Movie movie){
        return movie;
    }

    default ArrayList<Movie> read() throws SQLException {
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
                        rs.getString(TMOVIE_TITTLE),
                        rs.getString(TMOVIE_GENRE),
                        rs.getString(TMOVIE_CREATOR),
                        //dado que el dato es prmitivo int y short haremos un wrapped para recibir
                        // un string para convertirlo en un entero
                        Integer.valueOf(rs.getString(TMOVIE_DURATION)),
                        Short.valueOf(rs.getString(TMOVIE_YEAR)));
                //Dado que el constructor movie no posee id se genera por fuera
                movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
                movies.add(movie);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return movies;
    }

    private boolean getMovieViewed(){
        return false;
    }



}
