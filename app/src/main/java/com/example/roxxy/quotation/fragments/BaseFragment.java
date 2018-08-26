package com.example.roxxy.quotation.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.roxxy.quotation.ApplicationExtension;
import com.squareup.leakcanary.RefWatcher;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    protected BaseFragmentListener baseFragmentListener;
    protected Context context;
    protected Unbinder unbinder;
    protected AppCompatActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        activity = (AppCompatActivity) context;
        baseFragmentListener = (BaseFragmentListener) context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (context == null)
            return;
        RefWatcher refWatcher = ApplicationExtension.getRefWatcher(context);
        refWatcher.watch(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder == null)
            return;
        unbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
        context = null;
    }

    public interface BaseFragmentListener {
        void requestLoadingView();

        void requestCrossFade();

        void requestAlertDialog(String message);
    }

}