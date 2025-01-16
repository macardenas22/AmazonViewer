package org.mac.amazonviewer.db;

public class DataBase {
    //tendra todas las constante de base de datos
    public static final String URL                  ="jdbc:mysql://localhost:3306/";
    public static final String DB                   = "amazonviewer";
    public static final String USER                 = "root";
    public static final String PASSWORD             = "1234";
    // constante de tablas
    public static final String TMOVIE               ="movie";
    public static final String TMOVIE_ID            = "id";
    public static final String TMOVIE_TITTLE        = "title";
    public static final String TMOVIE_GENRE         ="genre";
    public static final String TMOVIE_CREATOR       ="creator";
    public static final String TMOVIE_DURATION      ="duration";
    public static final String TMOVIE_YEAR          = "year";

    public static final String TMATERIAL            = "material";
    public static final String TMATERIAL_ID         = "id";
    public static final String TMATERIAL_NAME       = "name";

    public static final int[]  ID_TMATERIALS       = {1,2,3,4,5};
    public static final int TUSER_IDUSUARIO = 1;


    public static final String TUSER                = "user";
    public static final String TUSER_ID             = "id";
    public static final String TUSER_NAME           = "name";

    public static final String TVIEWED              = "viewed";
    public static final String TVIEWED_ID           = "id";
    public static final String TVIEWED_IDMATERIAL   = "id_material";
    public static final String TVIEWED_IDELEMENT    = "id_element";
    public static final String TVIEWED_IDUSER       = "id_user";



}
