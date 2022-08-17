package com.waltermilcoff.newsapi.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class AuthorTest {

    private Author author;

    @Test
    void al_crear_un_author_se_carga_su_nombre_completo(){
        String firstname = "Walter";
        String lastname = "Milcoff";
        String nombreCompleto = author.getFullname();
        assertEquals(nombreCompleto, "Walter Milcoff");

    }
/*
    @Test
    void cuando_el_author_tiene_created_at_Ok(){
        int createdAtEsperado = 1;
        LocalDate fechaHaceUnAño = LocalDate.now().minusYears(1);
        Author author = new Author("Walter", "Milcoff", "Walter Milcoff", 1980-12-07, );
        int fechaCreatedActual = author.getCreatedAt();
        assertEquals(25, fechaCreatedActual);

    }

    @Test

    void cuando_el_author_esta_nominado_al_premio_novel_esta_ok(){
        Author author = new Author();
        assertTrue();

    }
    */

}