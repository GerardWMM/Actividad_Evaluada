package com.gerard.actividad_evaluada.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gerard.actividad_evaluada.Model.Pizza;
import com.gerard.actividad_evaluada.R;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder>{
    ArrayList<Pizza> pizzas_list;

    public PizzaAdapter(ArrayList<Pizza>list){
        this.pizzas_list = list;
    }

    @NonNull
    @Override
    public PizzaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaAdapter.ViewHolder holder, int position) {
        holder.cargar_Receta(pizzas_list.get(position));
    }

    @Override
    public int getItemCount() {
        return pizzas_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_TituloReceta, txt_ingredienteP, txt_base, txt_ingredientes, txt_alinios, txt_precio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_TituloReceta = itemView.findViewById(R.id.txt_TituloReceta);
            txt_ingredienteP = itemView.findViewById(R.id.txt_ingredienteP);
            txt_base = itemView.findViewById(R.id.txt_base);
            txt_ingredientes = itemView.findViewById(R.id.txt_ingredientes);
            txt_alinios = itemView.findViewById(R.id.txt_alinios);
            txt_precio = itemView.findViewById(R.id.txt_precio);

        }

        public void cargar_Receta(Pizza pizza){
            txt_TituloReceta.setText(pizza.getNombre());
            txt_ingredienteP.setText(pizza.getIngrediente_principal());
            txt_base.setText(pizza.getBase());

            String ingredientes = "";
            for(int i = 0; i < pizza.getIngredientes().size(); i++){
                if(i+1 < pizza.getIngredientes().size()){
                    ingredientes += pizza.getIngredientes().get(i) + "|";
                }else{
                    ingredientes += pizza.getIngredientes().get(i);
                }
                txt_ingredientes.setText(ingredientes);
            }

            String alinios = "";
            for(int i = 0; i < pizza.getAlinios().size(); i++){
                if(i+1 <pizza.getAlinios().size()){
                    alinios += pizza.getAlinios().get(i) + "|";
                }else{
                    alinios += pizza.getAlinios().get(i);
                }
                txt_alinios.setText(alinios);
            }

            txt_precio.setText(String.valueOf(pizza.getPrecio_total()));

        }
    }
}
