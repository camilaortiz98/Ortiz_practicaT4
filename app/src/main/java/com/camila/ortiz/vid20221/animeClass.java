package com.camila.ortiz.vid20221;

import java.io.Serializable;

public class animeClass implements Serializable {

    String Nombre;
    String Descripcion;
    String URL;
    String id;

    public animeClass() {

    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
/*
*  "titulo":"Shingeki no Kyojin",
      "descripcion":"Con Eren y compañía ahora en la costa y la amenaza de Marley acechando, ¿que sigue para los Scouts y su búsqueda para desentrañar los misterios de los Titanes, la humanidad y mas?",
      "imagen":"https://cdn.jkanime.net/assets/images/animes/image/shingeki-no-kyojin-the-final-season.jpg",
      "estrella":false
* */
