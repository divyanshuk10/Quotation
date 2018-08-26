package com.example.roxxy.quotation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.roxxy.quotation.fragments.BaseFragment;
import com.example.roxxy.quotation.fragments.HomeFragment;

public class MainActivity extends BaseActivity implements BaseFragment.BaseFragmentListener,HomeFragment.HomeFragmentListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    private static final String FRAGMENT_Home = "fragmentHome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        replaceFragment(new HomeFragment(), FRAGMENT_Home, true);

    }

    private void replaceFragment(Fragment fragment, String fragmentTag, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMainContainer, fragment, fragmentTag);
        if (addToBackStack)
            ft.addToBackStack(fragmentTag);
        ft.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    /*All overridden methods from fragments starts here*/

    @Override
    public void showChooseOptionsFragment() {
        Log.d(TAG, "showChooseOptionsFragment: here");
    }

    @Override
    public void requestLoadingView() {

    }

    @Override
    public void requestCrossFade() {

    }

    @Override
    public void requestAlertDialog(String message) {

    }
}
