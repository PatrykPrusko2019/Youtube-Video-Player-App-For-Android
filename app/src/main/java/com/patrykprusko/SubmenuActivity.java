package com.patrykprusko;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 *  class submenu
 *  using url -> https://www.youtube.com/watch?v=HwQBSUD07vQ&list=PLd6x4-VpRx7jixWOSzAvK31_xqXWXG16p&ab_channel=BrunoTerrosa
 */
public class SubmenuActivity extends AppCompatActivity implements View.OnClickListener {

    private final String GOOGLE_API_KEY = "ca15ad47-b77a-4e16-8f99-9b76227ea9aa";
    private final String YOUTUBE_VIDEO_ID = "HwQBSUD07vQ";
    private final String YOUTUBE_PLAYLIST = "PLd6x4-VpRx7jixWOSzAvK31_xqXWXG16p";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_submenu);

        Button buttonPlayVideo = (Button) findViewById(R.id.buttonPlayVideo);
        Button buttonPlayPlaylist = (Button) findViewById(R.id.buttonPlayPlaylist);

        buttonPlayVideo.setOnClickListener(this);
        buttonPlayPlaylist.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {

            case R.id.buttonPlayVideo :
                                                //createVideoIntent(Activity activity, String developerKey, String videoId, int timeMillis, boolean autoplay, boolean lightboxMode)
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID, 0 , true, false); // shows player youtube -> video
                break;

            case R.id.buttonPlayPlaylist :
                                             //createPlaylistIntent(Activity activity, String developerKey, String playlistId, int startIndex, int timeMillis, boolean autoplay, boolean lightboxMode)
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST, 0, 0, true, false); // shows player youtube -> playlist
                break;
        }

        startActivity(intent);

    }
}
