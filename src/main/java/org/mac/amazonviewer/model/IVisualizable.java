package org.mac.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
    /**
     * Este método captura el tiempo exacto de visualización
     * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto
     * @return Devuelve la fecha y hora capturada
     * */
    Date startToSee(Date dateI);
    /**
     * Este método captura el tiempo exacto de inicio y final de visualización
     * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto
     * @param dateF es un objeto {@code Date} con el tiempo de Final exacto
     * */

    void stopToSee(Date dateI, Date dateF);

}