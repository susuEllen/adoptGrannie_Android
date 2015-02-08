package com.example.ellenwong.adoptagrannie;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ellenwong on 2/7/15.
 */
public class ItemAdapter extends ArrayAdapter<Item> {
    // declaring our ArrayList of items
    private ArrayList<Item> objects;
    private static final String TAG = "ItemAdapter";
    private static RequestItemClickListner m_clickListener = null;

    /* here we must override the constructor for ArrayAdapter
    * the only variable we care about now is ArrayList<Item> objects,
    * because it is the list of objects we want to display.
    */
    public ItemAdapter(Context context, int textViewResourceId, ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    public void setItemClickListener(RequestItemClickListner listener) {
        m_clickListener = listener;
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

        final Item i = objects.get(position);
        final int pos = position;

        if (i != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.
            TextView distance_textview = (TextView) v.findViewById(R.id.list_item_distance_textView);
            TextView name_textview = (TextView) v.findViewById(R.id.list_item_name_textView);
            TextView requestName_textview = (TextView) v.findViewById(R.id.list_item_RequestName_textView);
            TextView startTime_textview = (TextView) v.findViewById(R.id.list_item_StartTime_textView);

            ImageView profile_icon = (ImageView)v.findViewById(R.id.list_item_profile_ImageView);
            ImageView status_Icon = (ImageView) v.findViewById(R.id.list_item_status_ImageView);


            // check to see if each individual textview is null.
            // if not, assign some text!
            if (distance_textview != null){
                distance_textview.setText(i.getDistance() + " mil");
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
            //String img = i.getImg_url();
            //String startTime = i.getTime();

            //TODO: populate UI for different status, image, startTime

            if(status != null) {
                if (status.equals(Item.STATUS_ACCEPTED)) {
                    Log.d(TAG, "item is accepted. status =  " + status);
                    if (status_Icon != null) {
                        status_Icon.setImageResource(R.drawable.ic_accept);
                    }
                } else {
                    Log.d(TAG, "item is Active. status =  " + status);
                    if (status_Icon != null) {
                        status_Icon.setImageResource(R.drawable.ic_more);
                    }
                }
            } else {
                //TODO: figure out why this can be null??? wtf
                Log.d(TAG, "status = null. item = " + i.toString());
            }

            // use hardcoded, prepopulated profile pictures of grannies
            if (profile_icon != null) {
                int resId = MainActivity.getHardCodedProfilePic(position);
                profile_icon.setImageResource(resId);
            }



            // Logic to navigate to each request detail
            if (status_Icon != null) {
                status_Icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(m_clickListener != null) {
                            m_clickListener.notifyRequestItemClicked(i, pos);
                        } else {
                            Log.d(TAG, "m_clickListener is null, notifyRequestItemClicked not called");
                        }

                    }
                });
            }
        }

        // the view must be returned to our activity
        return v;

    }

}