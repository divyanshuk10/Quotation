package com.example.roxxy.quotation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.roxxy.quotation.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private HomeFragmentListener listener;

    @BindView(R.id.imageButtonOpen)
    ImageButton imageButtonOpen;

    @BindView(R.id.textViewEmail)
    TextView textViewEmail;

    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity == null)
            return;
        android.support.v7.app.ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar == null)
            return;
        actionBar.hide();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.imageButtonOpen)
    void onClickImageButtonOpenAction() {
        listener.showChooseOptionsFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (HomeFragment.HomeFragmentListener) context;
    }

    public interface HomeFragmentListener {
        void showChooseOptionsFragment();
    }
}
