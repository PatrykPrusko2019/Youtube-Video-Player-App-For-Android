package com.patrykprusko;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


/**
 *  using url -> https://www.youtube.com/watch?v=HwQBSUD07vQ&list=PLd6x4-VpRx7jixWOSzAvK31_xqXWXG16p&ab_channel=BrunoTerrosa
 */
public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private final String GOOGLE_API_KEY = "ca15ad47-b77a-4e16-8f99-9b76227ea9aa";
    private final String YOUTUBE_VIDEO_ID = "HwQBSUD07vQ";
    private final String YOUTUBE_PLAYLIST = "PLd6x4-VpRx7jixWOSzAvK31_xqXWXG16p";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_youtube);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.activityYoutube);

        YouTubePlayerView youTubePlayerView = new YouTubePlayerView(this);
        youTubePlayerView.setLayoutParams(  new ConstraintLayout.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT )   );

        layout.addView(youTubePlayerView);

        youTubePlayerView.initialize(GOOGLE_API_KEY, this);

    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

        if( ! wasRestored ) {
            // youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
            youTubePlayer.cuePlaylist(YOUTUBE_PLAYLIST);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
