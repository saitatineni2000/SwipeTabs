package com.example.saisandeep.swipetabs;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MyActivity extends FragmentActivity implements ActionBar.TabListener {

    ActionBar ab;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        FragmentManager manager=getSupportFragmentManager();
        vp= (ViewPager) findViewById(R.id.pagers);
        MyAdapter adapter=new MyAdapter(manager);
        vp.setAdapter(adapter);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                Log.d("San","onPageScrolled was selected at position "+i+" from "+v+" with number of pixels="+i2);
            }

            @Override
            public void onPageSelected(int i) {

                ab.setSelectedNavigationItem(i);
                Log.d("San","onPageSelected was selected at position "+i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

                if(i==ViewPager.SCROLL_STATE_IDLE)
                {
                    Log.d("San","OnpageScrollState is Idle");
                }
                if(i==ViewPager.SCROLL_STATE_DRAGGING)
                {
                    Log.d("San","OnpageScrollState is Dragging");
                }
                if(i==ViewPager.SCROLL_STATE_SETTLING)
                {
                    Log.d("San","OnpageScrollState is Settling");
                }
            }
        });




        ab=getActionBar();//creating a action bar
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);//setting the navigation mode

        ActionBar.Tab tab1=ab.newTab();//creating a new tab using actionbar reference
        tab1.setText("Tab 1");//setting title for the tab
        tab1.setTabListener(this);

        ActionBar.Tab tab2=ab.newTab();
        tab2.setText("Tab 2");
        tab2.setTabListener(this);

        ActionBar.Tab tab3=ab.newTab();
        tab3.setText("Tab 3");
        tab3.setTabListener(this);

        ab.addTab(tab1);//adding the tab to the action bar
        ab.addTab(tab2);
        ab.addTab(tab3);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

       // Log.d("San","onTabSelected was selected at position "+tab.getPosition()+" and name is "+tab.getText());
        vp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        //Log.d("San","onTabUnSelected was selected at position "+tab.getPosition()+" and name is "+tab.getText());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        //Log.d("San","onTabReSelected was selected at position "+tab.getPosition()+" and name is "+tab.getText());
    }
}


class MyAdapter extends FragmentPagerAdapter
{

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment frag=null;

        if(i==0)
        {
            frag=new FragmentA();
        }
        if(i==1)
        {
            frag=new FragmentB();
        }
        if(i==2)
        {
            frag=new FragmentC();
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }
}