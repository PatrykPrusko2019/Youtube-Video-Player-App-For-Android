package com.patrykprusko;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


/**
 *   using url -> https://www.youtube.com/watch?v=HwQBSUD07vQ&list=PLd6x4-VpRx7jixWOSzAvK31_xqXWXG16p&ab_channel=BrunoTerrosa
 */
public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private final String TAG = "YoutubeActivity";
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

        Log.d(TAG, " on Initialization Success ");

        //used 2 interfaces -> displaying messages on how the player behaves
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        if( ! wasRestored ) {
             youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
            //youTubePlayer.cuePlaylist(YOUTUBE_PLAYLIST);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {

        final int REQUEST_CODE = 1;

        if(errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, REQUEST_CODE).show();
        } else {
            Toast.makeText(this, " onInitializationFailure -> " + errorReason.toString(), Toast.LENGTH_LONG).show();
        }

    }

    YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this, "turned on playing", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubeActivity.this, "turned on pause", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {
            Toast.makeText(YoutubeActivity.this, "turned on stop", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onBuffering(boolean b) {
            Toast.makeText(YoutubeActivity.this, "on buffering", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {
            Toast.makeText(YoutubeActivity.this, "player begins loading a video", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onLoaded(String s) {
            Toast.makeText(YoutubeActivity.this, "video has finished loading", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onAdStarted() {
            Toast.makeText(YoutubeActivity.this, "playback of an advertisement starts", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YoutubeActivity.this, "video starts", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(YoutubeActivity.this, "video ends", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

}
