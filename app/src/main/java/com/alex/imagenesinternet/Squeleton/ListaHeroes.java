package com.alex.imagenesinternet.Squeleton;

import android.graphics.Bitmap;

public class ListaHeroes {
    private String title;
    private String image;

    public ListaHeroes(String title, String bitmap){
        this.title=title;
        this.image=bitmap;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
