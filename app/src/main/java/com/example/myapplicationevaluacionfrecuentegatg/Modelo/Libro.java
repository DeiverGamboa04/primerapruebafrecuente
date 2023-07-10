package com.example.myapplicationevaluacionfrecuentegatg.Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Libro {

    private String title;
    private String volumen;
    private String year;
    private String portada;

    public Libro (JSONObject jsondato) throws JSONException {

        title = jsondato.getString("title");
        volumen = jsondato.getString("volume");
        year = jsondato.getString("year");
        portada = jsondato.getString("cover");

    }
    public static ArrayList<Libro> JsonObjectsBuild(JSONArray jsondato) throws JSONException {
        ArrayList<Libro> libro = new ArrayList<>();
        for (int i = 0; i < jsondato.length() && i<20; i++) {
            libro.add(new Libro(jsondato.getJSONObject(i)));
        }
        return libro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
