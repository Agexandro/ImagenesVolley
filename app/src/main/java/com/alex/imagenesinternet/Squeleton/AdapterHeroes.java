package com.alex.imagenesinternet.Squeleton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alex.imagenesinternet.R;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.net.ContentHandler;
import java.util.ArrayList;

public class AdapterHeroes  extends BaseAdapter {
    private Context context;
    private ArrayList<ListaHeroes> listaHeroes;
    ImageLoader imageLoader=RequestQ.getInstance().getImageLoader();
    public AdapterHeroes(Context c,ArrayList<ListaHeroes> l){
        this.context = c;
        this.listaHeroes = l;
    }

    @Override
    public int getCount() {
        return listaHeroes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);

            imageLoader=RequestQ.getInstance().getImageLoader();
            NetworkImageView image = convertView.findViewById(R.id.images);
            image.setImageUrl(listaHeroes.get(position).getImage(),imageLoader);
            TextView title = convertView.findViewById(R.id.titl);
            title.setText(listaHeroes.get(position).getTitle());

        return convertView;
    }
}
