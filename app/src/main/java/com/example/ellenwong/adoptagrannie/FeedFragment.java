//package com.example.ellenwong.adoptagrannie;
//
//import android.app.ActionBar;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
///**
// * Created by ellenwong on 2/7/15.
// */
//
///**
// * A placeholder fragment containing a simple view.
// */
//public class FeedFragment extends Fragment {
//
//    public FeedFragment() {
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
////
////            if (getActivity().getActionBar() != null) {
////                getActivity().getActionBar().setDisplayShowTitleEnabled(false);
////                getActivity().getActionBar().setDisplayShowHomeEnabled(false);
////                getActivity().getActionBar().setDisplayUseLogoEnabled(false);
////            }
//
//        ActionBar actionBar = getActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayShowTitleEnabled(false);
//        } else {
//            Log.d(TAG, "actionbar is null");
//        }
//
//
//        String [] testData = {"This", "is", "to", "test", "list"};
//        testDataArrayList = new ArrayList<String>(Arrays.asList(testData));
//
//        // Initialize an array adapter to display content in ListView
//
//        //TODO: create a custom Array adaptor
//        mChallengeListAdapter = new ArrayAdapter<String>(getActivity(),
//                R.layout.list_item_main,
//                R.id.list_item_name_textView,
//                testDataArrayList);
//
//        ListView listView = (ListView) rootView.findViewById(R.id.listView_main);
//        listView.setAdapter(mChallengeListAdapter);
//
//        return rootView;
//    }
//}
