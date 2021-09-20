package com.gerard.actividad_evaluada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gerard.actividad_evaluada.Model.Pizza;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Pizza>pizzas = new ArrayList<Pizza>();

    EditText txtReceta;
    RadioGroup ingredientePrincipal, base;
    CheckBox cbx_cebolla, cbx_champinion, cbx_tomate1, cbx_tomate2, cbx_morron, cbx_palta;
    CheckBox cbx_oregano, cbx_ajo, cbx_albaca;
    Button btn_guardar, btn_recetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtReceta = findViewById(R.id.txtNombreReceta);
        ingredientePrincipal = findViewById(R.id.ingredientePrincipal);
        base = findViewById(R.id.base);
        cbx_cebolla = findViewById(R.id.cbx_cebolla);
        cbx_champinion = findViewById(R.id.cbx_champinion);
        cbx_tomate1 = findViewById(R.id.cbx_tomate1);
        cbx_tomate2 = findViewById(R.id.cbx_tomate2);
        cbx_morron  = findViewById(R.id.cbx_morron);
        cbx_palta = findViewById(R.id.cbx_palta);
        cbx_oregano = findViewById(R.id.cbx_oregano);
        cbx_albaca = findViewById(R.id.cbx_albaca);
        cbx_ajo = findViewById(R.id.cbx_ajo);
        btn_guardar = findViewById(R.id.btn_guardar);
        btn_recetas = findViewById(R.id.btn_recetas);
    }

    public void guardarPizza(View view){
        int precio_total = 0;

        String nombreReceta = txtReceta.getText().toString();

        int id_ingredienteP = ingredientePrincipal.getCheckedRadioButtonId();
        RadioButton rbtn_ingredienteP = findViewById(id_ingredienteP);
        String ingredienteP = rbtn_ingredienteP.getText().toString();

        if(ingredienteP.equals("Carne")){
            precio_total += 1500;
        }else if(ingredienteP.equals("Pollo")){
            precio_total += 1500;
        }else if(ingredienteP.equals("Mix")){
            precio_total += 2000;
        }

        int id_base = base.getCheckedRadioButtonId();
        RadioButton rbtn_base = findViewById(id_base);
        String base = rbtn_base.getText().toString();
        precio_total += 500;

        String cebolla = null,champinion = null,tomate1 = null,tomate2 = null,morron = null
                ,palta = null ,oregano = null,ajo = null,albaca = null;
        if(cbx_cebolla.isChecked()){
            cebolla = cbx_cebolla.getText().toString();
        }
        if(cbx_champinion.isChecked()){
            champinion = cbx_champinion.getText().toString();
        }
        if(cbx_tomate1.isChecked()){
            tomate1 = cbx_tomate1.getText().toString();
        }
        if(cbx_tomate2.isChecked()){
            tomate2 = cbx_tomate2.getText().toString();
        }
        if(cbx_morron.isChecked()){
            morron = cbx_morron.getText().toString();
        }
        if(cbx_palta.isChecked()){
            palta = cbx_palta.getText().toString();
        }
        if(cbx_oregano.isChecked()){
            oregano = cbx_oregano.getText().toString();
        }
        if(cbx_ajo.isChecked()){
            ajo = cbx_ajo.getText().toString();
        }
        if(cbx_albaca.isChecked()){
            albaca = cbx_albaca.getText().toString();
        }

        ArrayList<String>ingredientes = new ArrayList<>();
        ArrayList<String>alinios = new ArrayList<>();
        if(cebolla != null){
            ingredientes.add(cebolla);
            precio_total += 1000;
        }
        if(champinion != null){
            ingredientes.add(champinion);
            precio_total += 1000;
        }
        if(tomate1 != null){
            ingredientes.add(tomate1);
            precio_total += 1000;
        }
        if(tomate2 != null){
            ingredientes.add(tomate2);
            precio_total += 1000;
        }
        if(morron != null){
            ingredientes.add(morron);
            precio_total += 1000;
        }
        if(palta != null){
            ingredientes.add(palta);
            precio_total += 1000;
        }
        if(oregano != null){
            alinios.add(oregano);
            precio_total += 500;
        }
        if(ajo != null){
            alinios.add(ajo);
            precio_total += 500;
        }
        if(albaca != null){
            alinios.add(albaca);
            precio_total += 500;
        }

        String resumen = String.valueOf(precio_total);
        Pizza nuevaPizza = new Pizza(nombreReceta,ingredienteP,base,ingredientes,alinios,precio_total);
        pizzas.add(nuevaPizza);
        if(pizzas.size()>0){
            Toast.makeText(this,"Receta guardada",Toast.LENGTH_LONG).show();
        }

    }

    public void ver_Recetas(View view){
        Intent intent = new Intent(getApplicationContext(),Recetas_Activity.class);
        startActivity(intent);
    }

}