package com.example.ellenwong.adoptagrannie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RequestInfoFragment extends Fragment {

    private static final String TAG = "RequestInfoFragment";

    private Item mItem = new Item();
    private String m_requestName = "";
    private String m_grannieName = "";
    private String m_startTime = "";
    private String m_distance = "";
    private String m_status = "";
    private String m_img = "";
    private String m_message = "";
    //private String m_address = "";

    public RequestInfoFragment() {
        // Required empty public constructor
    }

//    bundle.putString("requestName", item.getRequestName());
//    bundle.putString("grannieName", item.getGrannieName());
//    bundle.putString("startTime", item.getTime());
//    bundle.putString("distance", item.getDistance());
//    bundle.putString("status", item.getStatus());
//    bundle.putString("img", item.getImg_url());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_request_info, container, false);
        this.m_requestName = getArguments().getString("requestName");
        this.m_grannieName = getArguments().getString("grannieName");
        this.m_startTime = getArguments().getString("startTime");
        this.m_distance = getArguments().getString("distance");
        //this.m_status = getArguments().getString("status"); // probably dont need status in this view
        this.m_img = getArguments().getString("img");
        this.m_message = getArguments().getString("message");


        // TODO: create the textViews in the xml
        //
        //TextView requestName_textView = (TextView) rootView.findViewById(R.id.gr);
        TextView grannieName_textView = (TextView) rootView.findViewById(R.id.grannieName_TextView);
        //TextView distance_textView = (TextView) rootView.findViewById(R.id.gr);
        //TextView startTime_textView = (TextView) rootView.findViewById(R.id.xxx);
        //TextView address_textView = (TextView) rootView.findViewById(R.id.grannieAddress_TextView);
        TextView message_textView = (TextView) rootView.findViewById(R.id.grannieMessage_TextView);

        //Populate Fragment with item metadata
//        if (requestName_textView != null) {
//            requestName_textView.setText(this.m_requestName);
//        }

        if (grannieName_textView != null) {
            grannieName_textView.setText(this.m_grannieName);
        }

//        if (distance_textView != null) {
//            distance_textView.setText(this.m_distance);
//        }
//
//        if (startTime_textView != null) {
//            startTime_textView.setText(this.m_startTime);
//        }

//        if(address_textView != null) {
//            address_textView.setText(this.m_message);
//        }

        if (message_textView != null) {
            //message_textView.setText(this.m_message);
        }

        //TODO: do something for the image

        // Inflate the layout for this fragment
        Button acceptButton = (Button) rootView.findViewById(R.id.acceptButton);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:  you need to pass this back to MainActivity to accept
                // accept will then change status on a parse object
                // which will in turn trigger a mail send.
                Log.d(TAG, "acceptButton on click");
            }
        });

        return rootView;
    }


}
