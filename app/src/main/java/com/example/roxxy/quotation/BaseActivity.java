package com.example.roxxy.quotation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {

    protected View mLoadingView;
    protected View contentView;
    protected static final int ANIMATION_DURATION = 300;

    private void initializeViews() {
       /* if (mLoadingView == null)
            mLoadingView = findViewById(R.id.progressBar);
        if (contentView == null)
            contentView = findViewById(R.id.frame);*/
    }

    protected void showLoadingView() {
        initializeViews();
        contentView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    protected void crossFade() {
        initializeViews();

        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        contentView.setAlpha(0f);
        contentView.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        contentView.animate()
                .alpha(1f)
                .setDuration(ANIMATION_DURATION)
                .setListener(null);

        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        mLoadingView.animate()
                .alpha(0f)
                .setDuration(ANIMATION_DURATION)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mLoadingView.setVisibility(View.GONE);
                    }
                });
    }

    protected void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(R.string.ok,
                        (dialog, which) -> dialog.dismiss())
                .show();
    }
}