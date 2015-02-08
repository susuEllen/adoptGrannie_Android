package com.example.ellenwong.adoptagrannie;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ellenwong on 2/7/15.
 */
public class ItemAdapter extends ArrayAdapter<Item> {
    // declaring our ArrayList of items
    private ArrayList<Item> objects;
    private static final String TAG = "ItemAdapter";

    /* here we must override the constructor for ArrayAdapter
    * the only variable we care about now is ArrayList<Item> objects,
    * because it is the list of objects we want to display.
    */
    public ItemAdapter(Context context, int textViewResourceId, ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    /*
     * we are overriding the getView method here - this is what defines how each
     * list item will look.
     */
    public View getView(int position, View convertView, ViewGroup parent){

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_main, null);
        }

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */
        Item i = objects.get(position);

        if (i != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.
            TextView distance_textview = (TextView) v.findViewById(R.id.list_item_distance_textView);
            TextView name_textview = (TextView) v.findViewById(R.id.list_item_name_textView);
            TextView requestName_textview = (TextView) v.findViewById(R.id.list_item_RequestName_textView);
            TextView startTime_textview = (TextView) v.findViewById(R.id.list_item_StartTime_textView);


            // check to see if each individual textview is null.
            // if not, assign some text!
            if (distance_textview != null){
                distance_textview.setText(i.getDistance());
            }
            if (name_textview != null){
                name_textview.setText(i.getGrannieName());
            }
            if (requestName_textview != null){
                requestName_textview.setText(i.getRequestName());
            }
            if (startTime_textview != null){
                startTime_textview.setText(i.getTime());
            }

            String status = i.getStatus();
            String img = i.getImg_url();
            String startTime = i.getTime();

            //TODO: populate UI for different status, image, startTime
            Log.d(TAG, "status = " + status + " img = " + img + " startTime = " + startTime);
        }

        // the view must be returned to our activity
        return v;

    }

}