package com.example.smartbus;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Y on 11/1/2018.
 */

public class ArtistList extends ArrayAdapter<UserData> {
    private Activity context;
    private List<UserData> artistList;



    public ArtistList(Activity context, List<UserData> artistList) {
        super(context,R.layout.list_layout,artistList);
        this.context=context;
        this.artistList=artistList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewName=(TextView)listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre=(TextView)listViewItem.findViewById(R.id.textViewGenre);
        UserData artist=artistList.get(position);
        textViewName.setText(artist.getName());
        textViewGenre.setText(artist.getCourse());
        return listViewItem;
    }
}
