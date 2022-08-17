package com.waltermilcoff.newsapi.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SourceTest {

    private Source source;


    @Test
    void al_crear_una_fuente_el_nombre_crea_corectamente_elcode_Ok(){
        String name = "La Nacion";
        String code = source.getCode();

        assertEquals("la-nacion", code);
    }

}