package com.medilatam.backend.Utils;

import com.medilatam.backend.Security.Enums.EstadoConsulta;
import com.medilatam.backend.Security.Enums.TipoConsulta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.datetime.DateFormatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

//REVISION
@Slf4j
public class UtilMethods {

    public static  Date convertStringToSqlDate(String fecha)  { // Convierte un string a una fecha de tipo lDate
        try {
            DateFormatter formatter = new DateFormatter("yyyy-MM-dd");
            Date date = formatter.parse(fecha, Locale.ENGLISH);
            return date;
        } catch (ParseException e) {
            log.error("Error al convertir la fecha");
            return null;

        }
    }
    public static EstadoConsulta setEstadoConsulta(Integer estadoConsulta){
        switch (estadoConsulta){
            case 1:
                return EstadoConsulta.NO_ATENDIDO;
            case 2:
                return EstadoConsulta.ATENDIDO;
            case 3:
                return EstadoConsulta.CANCELADA;
            default:
                return null;
        }
    }
    public static TipoConsulta setTipoConsulta(Integer tipoConsulta){
        switch (tipoConsulta){
            case 1:
                return TipoConsulta.PRESENCIAL;
            case 2:
                return TipoConsulta.VIRTUAL;
            default:
                return null;
        }
    }
}
