package com.camila.ortiz.vid20221;

public class animeClass {
    String titulo;
    String descripcion;
    String imagen;
    boolean estrella;


    public animeClass(String titulo, String descripcion, String imagen, boolean estrella) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.estrella = estrella;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isEstrella() {
        return estrella;
    }

    public void setEstrella(boolean estrella) {
        this.estrella = estrella;
    }
}
/*
*  "titulo":"Shingeki no Kyojin",
      "descripcion":"Con Eren y compañía ahora en la costa y la amenaza de Marley acechando, ¿que sigue para los Scouts y su búsqueda para desentrañar los misterios de los Titanes, la humanidad y mas?",
      "imagen":"https://cdn.jkanime.net/assets/images/animes/image/shingeki-no-kyojin-the-final-season.jpg",
      "estrella":false
* */
