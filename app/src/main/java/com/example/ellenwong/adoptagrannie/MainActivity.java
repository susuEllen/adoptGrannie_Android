package com.example.ellenwong.adoptagrannie;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    private static String TAG = "MainActivity";
    private static final String APP_ID_PARSE = "lfv0uvEoiM8gxprHYW0vUQeiZmtqG7LGLRkexPcC";
    private static final String CLIENT_ID_PARSE = "zbtgIdiPRLrDudeksMcpWu6VxeCwPHfLeVOPjvMb";

    private static ArrayAdapter<String> mChallengeListAdapter = null;
    private static ArrayList<String> testDataArrayList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.registerParseObjects();

        // Get rid of annoygin title text
        //TODO: integrate parse SDK
        //Parse.initialize(this, APP_ID_PARSE, CLIENT_ID_PARSE);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FeedFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_home) {

            replaceWithFeedFragment();

        } else if (id == R.id.action_profile) {

            replaceWithProfile();
        } else if (id == R.id.action_testRequest) {

            replaceWithRequestInfo();
        }

        return super.onOptionsItemSelected(item);
    }


    private void replaceWithFeedFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FeedFragment())
                .commit();

    }

    private void replaceWithRequestInfo() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new RequestInfoFragment())
                .commit();

    }

    private void replaceWithProfile() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ProfileFragment())
                .commit();
    }


    private void registerParseObjects() {
        //TODO: register elderly request object
        // register other objects needed
        //ParseObject.registerSubclass(ChallengeListItem.class);
        //ParseObject.registerSubclass(User_Challenge_Relationship.class);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public class FeedFragment extends Fragment {

        public FeedFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

//            if (getActivity().getActionBar() != null) {
//                getActivity().getActionBar().setDisplayShowTitleEnabled(false);
//                getActivity().getActionBar().setDisplayShowHomeEnabled(false);
//                getActivity().getActionBar().setDisplayUseLogoEnabled(false);
//            }

            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowTitleEnabled(false);
            } else {
                Log.d(TAG, "actionbar is null");
            }


            String [] testData = {"This", "is", "to", "test", "list"};
            testDataArrayList = new ArrayList<String>(Arrays.asList(testData));

            // Initialize an array adapter to display content in ListView

            //TODO: create a custom Array adaptor
            mChallengeListAdapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.list_item_main,
                    R.id.list_item_name_textView,
                    testDataArrayList);

            ListView listView = (ListView) rootView.findViewById(R.id.listView_main);
            listView.setAdapter(mChallengeListAdapter);

            return rootView;
        }
    }
}
