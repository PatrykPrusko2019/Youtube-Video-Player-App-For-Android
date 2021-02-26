package com.patrykprusko;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


// ca15ad47-b77a-4e16-8f99-9b76227ea9aa -> Google api key

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlaySingleVideo = (Button) findViewById(R.id.buttonPlaySingleVideo);
        Button btnPlaySubmenu = (Button) findViewById(R.id.buttonOpenSubmenu);

        btnPlaySingleVideo.setOnClickListener(this);
        btnPlaySubmenu.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.buttonPlaySingleVideo :
                intent = new Intent(this, YoutubeActivity.class);
            break;

            case R.id.buttonOpenSubmenu :
                intent = new Intent(this, SubmenuActivity.class);
            break;

            default:
                //nothing
        }
        startActivity(intent);

    }
}