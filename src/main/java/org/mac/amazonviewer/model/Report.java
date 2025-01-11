package org.mac.amazonviewer.model;

import java.io.*;

public class Report {

    /** <b>Report</b>:
     * es una clase publica que permite la generación de un archivo plano (txt), la cual se puede utilizar
     en cualquier proyecto que requiera por ejemplo, generación de logs o de tramas diversas.
     *Report *<p> *Esta es la clase genera reportes en la extension deseada,
     Este tiene como parametros obligotorios los siguientes atributos
     @param Content {@code String}
     @param Extension {@code String}
     @param NameFile {@code String} *@param Title {@code String}

     @author Mauricio.Cardenas
     @version 1.0.0.1
     @since 2025
     */


    private String nameFile;
    private String title;
    private String content;
    private String extension;

    public String getNameFile() {
        return nameFile;
    }
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public void makeReport() {
        if ( (getNameFile() != null) && (getTitle() != null) && (getContent() != null) ) {
            //Crear el archivo
            try {

                File file = new File(getNameFile()+"."+getExtension());
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(getContent());
                bw.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {
            System.out.println("Ingresa los datos del archivo");
        }
    }



    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
}
