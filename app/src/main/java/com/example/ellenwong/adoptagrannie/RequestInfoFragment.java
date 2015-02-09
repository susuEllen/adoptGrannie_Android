package com.example.ellenwong.adoptagrannie;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
    //private String m_img = "";
    private int m_img_index = 0;
    private String m_message = "";
    private String m_itemId = "";
    //private String m_address = "";

    private AcceptItemClickListener mAcceptItemClickListener = null;

    public RequestInfoFragment() {
        // Required empty public constructor
    }

    public void setAcceptItemClickListener(AcceptItemClickListener listener) {
        this.mAcceptItemClickListener = listener;
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
        this.m_status = getArguments().getString("status");
        this.m_img_index = getArguments().getInt("img");
        this.m_message = getArguments().getString("message");
        this.m_itemId = getArguments().getString("itemId");



        // TODO: create the textViews in the xml
        //
        //TextView requestName_textView = (TextView) rootView.findViewById(R.id.gr);
        TextView grannieName_textView = (TextView) rootView.findViewById(R.id.grannieName_TextView);
        //TextView distance_textView = (TextView) rootView.findViewById(R.id.gr);
        //TextView startTime_textView = (TextView) rootView.findViewById(R.id.xxx);
        //TextView address_textView = (TextView) rootView.findViewById(R.id.grannieAddress_TextView);
        TextView message_textView = (TextView) rootView.findViewById(R.id.grannieMessage_TextView);
        ImageView profile_imageView = (ImageView) rootView.findViewById(R.id.grannie_ImageView);
        TextView adopt_textView = (TextView) rootView.findViewById(R.id.grannieAdopt_TextView);

        if (adopt_textView != null) {
            adopt_textView.setVisibility(View.GONE);
        }

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
            message_textView.setText(this.m_message);
        }

        if(profile_imageView != null) {
            int resId = MainActivity.getHardCodedProfilePic(m_img_index);
            profile_imageView.setImageResource(resId);
        }

        // Inflate the layout for this fragment
        Button acceptButton = (Button) rootView.findViewById(R.id.acceptButton);
        if (acceptButton != null) {
            //TODO: Logic to disable button if request is already accepted

            if (m_status!= null && !m_status.equals(Item.STATUS_ACTIVE)) {
                Log.d(TAG, "accepted, button disabled. m_status = " + m_status);
                acceptButton.setBackgroundColor(Color.GREEN);
                acceptButton.setText("Request Accepted");
                acceptButton.setClickable(false);
                acceptButton.setEnabled(false);

                if (adopt_textView != null) {
                    adopt_textView.setVisibility(View.VISIBLE);
                    //TODO: create a toast to allow user to "adopt that elderly"
                }

            } else {
                Log.d(TAG, "not accepted. m_status = " + m_status);
                if (acceptButton != null) {
                    acceptButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //TODO:  you need to pass this back to MainActivity to accept
                            // accept will then change status on a parse object
                            // which will in turn trigger a mail send.

                            if (mAcceptItemClickListener != null) {
                                mAcceptItemClickListener.notifyAcceptItemClicked(RequestInfoFragment.this.m_itemId);
                            } else {
                                Log.d(TAG, "mAcceptItemClickListener is null cannot notifyAcceptItemClicked ");
                            }

                        }
                    });
                }
            }
        }
        return rootView;
    }


}
