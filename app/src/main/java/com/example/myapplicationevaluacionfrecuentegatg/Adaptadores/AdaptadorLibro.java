package com.example.myapplicationevaluacionfrecuentegatg.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplicationevaluacionfrecuentegatg.Modelo.Libro;
import com.example.myapplicationevaluacionfrecuentegatg.R;

import java.util.ArrayList;

public class AdaptadorLibro extends ArrayAdapter<Libro> {
    public AdaptadorLibro(Context context, ArrayList<Libro> dato){
        super(context, R.layout.lyitemedicion,dato);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemedicion, null);

        TextView lblnombreedicion = (TextView)item.findViewById(R.id.txtnombreedicion);
        lblnombreedicion.setText(getItem(position).getTitle());

        TextView lblvolumen = (TextView)item.findViewById(R.id.twvolumen);
        lblvolumen.setText(getItem(position).getVolumen());

        TextView lblyear = (TextView)item.findViewById(R.id.twyear);
        lblyear.setText(getItem(position).getYear());


        ImageView imagenView = (ImageView)item.findViewById(R.id.imagenportada);
        Glide.with(this.getContext()).load(getItem(position).getPortada()).into(imagenView);
        return(item);
    }
}
