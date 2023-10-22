package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    String isbn, titulo, autor;
    int numeroPaginas, anyPublicacion;

}
