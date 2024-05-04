package com.medilatam.backend.Utils;

import com.medilatam.backend.Security.Enums.EstadoConsulta;
import com.medilatam.backend.Security.Enums.TipoConsulta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

//REVISION
@Slf4j
@RestControllerAdvice
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
    // Manejo de campos no nulos
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public static String manejoDeCampoNoNulo(MethodArgumentNotValidException ex){
        Map<String,String> errors= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(e->{ //Esta es una lista de errores
            String fieldName= ((FieldError) e).getField();
            String message= e.getDefaultMessage();
            errors.put(fieldName,message); // Ingreso en el hashmap cada clave-valor de los errores
        });
        return errors.toString();
    }
    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
    public static String manejoDeCampoNoNulo(jakarta.validation.ConstraintViolationException e){
        Map<String, String> errors = new HashMap<>();
        e.getConstraintViolations().forEach(err -> {
            String fieldName = err.getPropertyPath().toString();
            String message = err.getMessage();
            errors.put(fieldName, message);
        });
        return errors.toString();
    }

}
