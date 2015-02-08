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
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements RequestItemClickListner, AcceptItemClickListener {


    private static String TAG = "MainActivity";
    private static final String APP_ID_PARSE = "lfv0uvEoiM8gxprHYW0vUQeiZmtqG7LGLRkexPcC";
    private static final String CLIENT_ID_PARSE = "zbtgIdiPRLrDudeksMcpWu6VxeCwPHfLeVOPjvMb";

    //private static ItemAdapter<Item> mChallengeListAdapter = null;
    private static ItemAdapter mRequestListAdapter = null;
    //private static ArrayList<String> testDataArrayList = null;
    private static ArrayList<Item> itemArrayList = null;

    private static ArrayList<Integer> profile_img_drawables = new ArrayList<Integer>();

    private void hardCodeProfileImages() {
        Log.d(TAG, "In hardCodeProfileImages");
//        profile_img_drawables.add(Integer.valueOf(R.drawable.crazy_old_lady));
//        profile_img_drawables.add(Integer.valueOf(R.drawable.cute_lady));
//        profile_img_drawables.add(Integer.valueOf(R.drawable.grandpa_pic1));
//        //profile_img_drawables.add(Integer.valueOf(R.drawable.rich_grandpa));
//        profile_img_drawables.add(Integer.valueOf(R.drawable.smile_grannie));
//        profile_img_drawables.add(Integer.valueOf(R.drawable.smile_grannie_2));
//        //profile_img_drawables.add(Integer.valueOf(R.drawable.talking_grannie));
//        profile_img_drawables.add(Integer.valueOf(R.drawable.ic_grandma_pic));
        profile_img_drawables.add(Integer.valueOf(R.drawable.ic_profile_man1));

    }

    public static Integer getHardCodedProfilePic(int listIndex) {
        int index = listIndex % profile_img_drawables.size();
        return profile_img_drawables.get(index);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.registerParseObjects();

        // Get rid of annoygin title text
        Parse.initialize(this, APP_ID_PARSE, CLIENT_ID_PARSE);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FeedFragment())
                    .commit();
        }
        hardCodeProfileImages();
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

            //replaceWithRequestInfo(new Item());
        }

        return super.onOptionsItemSelected(item);
    }


    private void replaceWithFeedFragment() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FeedFragment())
                .commit();

    }

    private void replaceWithRequestInfo(Item item, int indexImg) {
        RequestInfoFragment requestInfoFragment = new RequestInfoFragment();
        requestInfoFragment.setAcceptItemClickListener(this);

        if(item != null) {
            Bundle bundle = new Bundle();
            //bundle.putString("requestName", item.getRequestName());
            bundle.putString("grannieName", item.getGrannieName());
            bundle.putString("itemId", item.getObjectId());
            //bundle.putString("startTime", item.getTime());
            //bundle.putString("distance", item.getDistance());
            //bundle.putString("status", item.getStatus());
            bundle.putInt("img", indexImg);
            bundle.putString("message", item.getMessage());

            // set Fragmentclass Arguments
            requestInfoFragment.setArguments(bundle);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, requestInfoFragment)
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
        ParseObject.registerSubclass(Item.class);
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

            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowTitleEnabled(false);
            } else {
                Log.d(TAG, "actionbar is null");
            }

            fetchGrannieRequestsFromParse();


            Item defaultItem = new Item();
            itemArrayList = new ArrayList<Item>();
            itemArrayList.add(defaultItem);

            // Initialize an array adapter to display content in ListView
            mRequestListAdapter = new ItemAdapter(getActivity(), R.layout.list_item_main, itemArrayList);
            mRequestListAdapter.setItemClickListener(MainActivity.this);

            ListView listView = (ListView) rootView.findViewById(R.id.listView_main);
            listView.setAdapter(mRequestListAdapter);

            return rootView;
        }

    }

    private void fetchGrannieRequestsFromParse() {
        Log.d(TAG, "fetchGrannieRequestsFromParse");
        ParseQuery<Item> grannieRequests = Item.getQuery();
        grannieRequests.findInBackground(new FindCallback<Item>() {
            @Override
            public void done(List<Item> items, ParseException e) {

                // TODO: handle Requests returned from grannieRequests
                Log.d(TAG, "items count = " + items.size());

                if (items != null && items.size() > 0) {
                    Log.d(TAG, items.get(0).toString());
                }

                if (items != null && items.size() > 0) {
                    mRequestListAdapter.clear();

                    for (Item item : items) {
                        //String img, String rName, String gName, String t, String d , String s
                        //Item newItem = new Item(item.getImg_url(), item.getGrannieName(), item.getRequestName(), item.getTime(), item.getDistance(), item.getStatus());
                        mRequestListAdapter.add(item);
                    }
                }
            }
        });



    }

    @Override
    public void notifyAcceptItemClicked(String requestId) {
        Log.d(TAG, "In notifyAcceptItemClicked. requestId = " + requestId);

        ParseQuery<Item> query = ParseQuery.getQuery("Request");

        // Retrieve the object by id
        query.getInBackground(requestId, new GetCallback<Item>() {
            public void done(Item requestItem, ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data.
                    if (requestItem != null) {
                        requestItem.put(Item.STATUS, Item.STATUS_ACCEPTED);
                        requestItem.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                replaceWithFeedFragment();
                            }
                        });
                    }
                }
            }
        });


    }

    @Override
    public void notifyRequestItemClicked(Item i, int index) {
        //TODO: pass in actual data
        // start Request Activity with item i
        // which has all the info you need for the Request Info Fragment

        replaceWithRequestInfo(i, index);

    }
}
