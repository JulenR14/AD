package org.julen.ejercicio13relaciones.mapper;

import org.julen.ejercicio13relaciones.model.Driver;
import org.julen.ejercicio13relaciones.model.DriverDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDate;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface FormulaMapper {

    @Mappings({
            @Mapping(target = "code", source = "code"),
            @Mapping(target = "fullName", expression = "java(crearFullName(driver.getForename(), driver.getSurname()))"),
            @Mapping(target = "dob", source = "dob")
    })
    DriverDTO toDriverDTO(Driver driver);

    default String crearFullName(String forename, String surname){
        return forename + " " + surname;
    }

}
