package com.example.myapplicationevaluacionfrecuentegatg.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplicationevaluacionfrecuentegatg.Modelo.Revista;
import com.example.myapplicationevaluacionfrecuentegatg.R;

import java.util.ArrayList;

public class AdaptadorRevista extends ArrayAdapter<Revista> {

    public AdaptadorRevista(Context context, ArrayList<Revista> datos){
        super(context, R.layout.lyitemrevista,datos);

    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemrevista, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.txtnombre);
        lblNombre.setText(getItem(position).getName());


        ImageView imageView = (ImageView)item.findViewById(R.id.imgportada);
        Glide.with(this.getContext()).load(getItem(position).getPortada()).into(imageView);
        return(item);
    }


}

