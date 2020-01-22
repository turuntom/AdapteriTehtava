package com.example.tuntiesimerkkiadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class OmaAdapteri extends ArrayAdapter<Date> {

    private Context context;
    private LayoutInflater layoutInflater;

    private TextView dateView;
    private Button remove;

    private ArrayList<Date> dates;

    public OmaAdapteri(@NonNull Context context, int resource, @Nullable ArrayList<Date> dates) {
        super(context, resource);
        this.layoutInflater = LayoutInflater.from(context);
        this.dates = dates;
        this.context = context;

    }



    @Override
    public void add(@Nullable Date object) {
        super.add(object);
        dates.add(object);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view = layoutInflater.inflate(R.layout.omaleiska, parent, false);
        dateView = (TextView) view.findViewById(R.id.dateView);

        Date currentDate = dates.get(position);

        dateView.setText(currentDate.toString());
        remove = (Button) view.findViewById(R.id.removeNappi);
        remove.setOnClickListener(removeNapinKuuntelija);
        return view;

    }


    View.OnClickListener removeNapinKuuntelija = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Oma adaptori kuuntelijea", Toast.LENGTH_SHORT).show();
            dateView.setText("");
            remove.setEnabled(false);
        }
    };

    //public OmaAdapteri(@NonNull Context context, int resource, @NonNull List<String> objects){
    //   super(context,resource,objects);
    //   this.context = context;
    //   this.dataset = (ArrayList<String>) objects;
    // }

    //@NonNull
    //@Override
    //public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
    //LayoutInflater layoutInflater = LayoutInflater.from(context);
    //View v = layoutInflater.inflate();

    //LinearLayout linearLayout = (LinearLayout) v;
    //Button b = (Button)linearLayout.findViewById(R.id.nappi);
    //b.setOnClickListener();

    //return linearLayout;
    //}

}
