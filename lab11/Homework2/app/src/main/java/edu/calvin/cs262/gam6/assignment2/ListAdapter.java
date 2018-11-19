package edu.calvin.cs262.gam6.assignment2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter {
    private final Activity context;


    private final Player[] playerArray;


    public ListAdapter( Activity context, Player[] playerArray ) {
        super(context, R.layout.listview_item , playerArray);
        this.context = context;
        this.playerArray = playerArray;
    }

    public View getView(int idx, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_item, null,true);

        TextView idTv = rowView.findViewById(R.id.id);
        TextView emailTv =  rowView.findViewById(R.id.email);
        TextView nameTv = rowView.findViewById(R.id.name);

        if ( rowView != null ) {
            idTv.setText( String.valueOf( playerArray[idx].id) );
            emailTv.setText(playerArray[idx].email);
            nameTv.setText(playerArray[idx].name);
        }

        return rowView;

    }

}