package com.example.a.woofui;


import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by apple on 2018/3/4.
 */

public class WalkActivity extends AppCompatActivity {

    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mate_main);
        final PostWalk postMateFragment = new PostWalk();
        final AvailableWalk availableMateFragment = new AvailableWalk();
        final RequestsWalk requestsMateFragment = new RequestsWalk();
        final RequestedWalk requestedMateFragment = new RequestedWalk();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, postMateFragment).commit();
        final TextView btn_post = findViewById(R.id.post_mate);
        final TextView btn_available = findViewById(R.id.available);
        final TextView btn_requests = findViewById(R.id.requests);
        final TextView btn_requested = findViewById(R.id.requested);
        btn_post.setTextColor(getResources().getColor(R.color.colorPrimary));
        for(Drawable mDrawable : btn_post.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
        {
            if(mDrawable!=null) {
                //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                mDrawable.setColorFilter(new
                        PorterDuffColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP));


            }
        }
        /*
        final Drawable[] icon_post = btn_post.getCompoundDrawables();
        final Drawable[] icon_available = btn_available.getCompoundDrawables();
        final Drawable[] icon_requests = btn_requests.getCompoundDrawables();
        final Drawable[] icon_requested = btn_requested.getCompoundDrawables();
        */
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_post.setTextColor(getResources().getColor(R.color.colorPrimary));
                btn_available.setTextColor(getResources().getColor(R.color.defaultIcon));
                btn_requested.setTextColor(getResources().getColor(R.color.defaultIcon));
                btn_requests.setTextColor(getResources().getColor(R.color.defaultIcon));
                for(Drawable mDrawable : btn_post.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_available.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_requested.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_requests.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                //PostMate postMateFragment = new PostMate();
                manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.container, postMateFragment)
                        .commit();
            }
        });
        btn_available.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_post.setTextColor(getResources().getColor(R.color.defaultIcon));
                btn_available.setTextColor(getResources().getColor(R.color.colorPrimary));
                btn_requested.setTextColor(getResources().getColor(R.color.defaultIcon));
                btn_requests.setTextColor(getResources().getColor(R.color.defaultIcon));
                for(Drawable mDrawable : btn_post.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_available.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_requested.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_requests.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                //AvailableMate availableMateFragment = new AvailableMate();
                manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.container, availableMateFragment)
                        .commit();
            }
        });
        btn_requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_post.setTextColor(getResources().getColor(R.color.defaultIcon));
                btn_available.setTextColor(getResources().getColor(R.color.defaultIcon));
                btn_requested.setTextColor(getResources().getColor(R.color.defaultIcon));
                btn_requests.setTextColor(getResources().getColor(R.color.colorPrimary));
                for(Drawable mDrawable : btn_post.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_available.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_requested.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_requests.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.container,requestsMateFragment)
                        .commit();
            }
        });
        btn_requested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_post.setTextColor(getResources().getColor(R.color.defaultIcon));
                btn_available.setTextColor(getResources().getColor(R.color.defaultIcon));
                btn_requested.setTextColor(getResources().getColor(R.color.colorPrimary));
                btn_requests.setTextColor(getResources().getColor(R.color.defaultIcon));
                for(Drawable mDrawable : btn_post.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_available.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_requested.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                for(Drawable mDrawable : btn_requests.getCompoundDrawables()) //getResources().getDrawable(R.drawable.ic_post);
                {
                    if(mDrawable!=null) {
                        //mDrawable.setTint(getResources().getColor(R.color.colorPrimary));
                        mDrawable.setColorFilter(new
                                PorterDuffColorFilter(getResources().getColor(R.color.defaultIcon), PorterDuff.Mode.SRC_ATOP));


                    }
                }
                manager.beginTransaction()
                        .replace(R.id.container, requestedMateFragment)
                        .commit();
            }
        });



    }

    public void walkPosted(Boolean resp)
    {
        if(resp)
        {
            Snackbar.make(findViewById(R.id.container),"Posted Successfully",Snackbar.LENGTH_SHORT).show();
        }
        else
            Snackbar.make(findViewById(R.id.container),"Some Error Occured",Snackbar.LENGTH_SHORT).show();
    }


}

