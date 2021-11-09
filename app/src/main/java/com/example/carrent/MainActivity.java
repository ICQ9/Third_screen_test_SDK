package com.example.carrent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.admixer.sdk.AdListener;
import net.admixer.sdk.AdView;
import net.admixer.sdk.BannerAdView;
import net.admixer.sdk.ResultCode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //LinearLayout container;

    RecyclerView recyclerView;
    RecyclerView.Adapter programManager;
    RecyclerView.LayoutManager layoutManager;
    LinearLayout container;


    String[] programNameList = {"C", "C++", "Java", "Android", "HTML5", "CSS3", "JavaScript", "jQuery", "Bootstrap", "PHP",
            "MySQL", "CodeIgniter", "React", "NodeJS", "AngularJS", "PostgreSQL", "Python", "C#", "Wordpress", "GitHub"};
    String[] programDescriptionList = {"C Description", "C++ Description", "Java Description",
            "Android Description", "HTML5 Description",
            "CSS3 Description", "JavaScript Description", "jQuery Description",
            "Bootstrap Description", "PHP Description", "MySQL Description",
            "CodeIgniter Description", "React Description", "NodeJS Description",
            "AngularJS Description", "PostgreSQL Description", "Python Description",
            "C# Description", "Wordpress Description", "GitHub Description"};


    int[] programImages = {R.drawable.c, R.drawable.cplusplus,
            R.drawable.java, R.drawable.android, R.drawable.html5,
            R.drawable.css3, R.drawable.javascript, R.drawable.jquery,
            R.drawable.bootstrap, R.drawable.php, R.drawable.mysql,
            R.drawable.codeigniter, R.drawable.react, R.drawable.nodejs,
            R.drawable.angularjs, R.drawable.postgresql, R.drawable.python,
            R.drawable.csharp, R.drawable.wordpress, R.drawable.github};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        container = findViewById(R.id.banner_ad_view);
        container.removeAllViews();
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        programManager = new ProgramAdapter(this,programNameList,programDescriptionList,programImages);

        recyclerView.setAdapter(programManager);

        Button next_screen = findViewById(R.id.button_first_screen);
        next_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this ,SecondScreen.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        container.removeAllViews();
        setup_banner();

    }

    private void setup_banner(){

        final BannerAdView bannerAdView = new BannerAdView(this);
        bannerAdView.setPlacementID("f9a26255-08a2-40ec-9667-3ab35e69625a");

        ArrayList<net.admixer.sdk.AdSize> adSizes = new ArrayList<>();

        adSizes.add(new net.admixer.sdk.AdSize(300,250));
        bannerAdView.setAdSizes(adSizes);

        bannerAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded(AdView adView) {

            }

            @Override
            public void onAdRequestFailed(AdView adView, ResultCode resultCode) {

            }

            @Override
            public void onAdExpanded(AdView adView) {

            }

            @Override
            public void onAdCollapsed(AdView adView) {

            }

            @Override
            public void onAdClicked(AdView adView) {

            }

            @Override
            public void onAdClicked(AdView adView, String s) {

            }
        });
        container.removeAllViews();
        container.addView(bannerAdView);

        bannerAdView.loadAd();



    }
}