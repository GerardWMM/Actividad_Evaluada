package com.gerard.actividad_evaluada.Model;

import java.util.ArrayList;

public class Pizza {
    private String nombre;
    private String ingrediente_principal;
    private String base;
    private ArrayList<String>ingredientes;
    private ArrayList<String>alinios;
    private int precio_total;

    public Pizza(String nombre, String ingrediente_principal, String base, ArrayList<String> ingredientes, ArrayList<String> alinios, int precio) {
        this.nombre = nombre;
        this.ingrediente_principal = ingrediente_principal;
        this.base = base;
        this.ingredientes = ingredientes;
        this.alinios = alinios;
        this.precio_total = precio;

    }

    public String getNombre() {
        return nombre;
    }

    public String getIngrediente_principal() {
        return ingrediente_principal;
    }

    public String getBase() {
        return base;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public ArrayList<String> getAlinios() {
        return alinios;
    }

    public int getPrecio_total() {
        return precio_total;
    }

}
