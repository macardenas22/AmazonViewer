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

    public static final String TUSER                = "user";
    public static final String TUSER_ID             = "id";
    public static final String TUSER_NAME           = "name";

    public static final String TVIEWED              = "viewed";
    public static final String TID_ID               = "id";
    public static final String TID_MATERIAL_NAME    = "id_material";
    public static final String TID_ELEMENT_NAME     = "id_element";
    public static final String TID_USER_NAME        = "id_user";



}
