package com.davisilvaprojetos.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity
            implements YouTubePlayer.OnInitializedListener {
    private YouTubePlayerView youTubePlayerView;
    private static final String GOOGLE_API_KEY = "AIzaSyCr1wu-2qV6n9scn2tcrpxJAMJPeFcAgKk";

    private YouTubePlayer.PlaybackEventListener playbackEventListener;
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {
                Toast.makeText(MainActivity.this, "Video carregando", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoaded(String s) {
                Toast.makeText(MainActivity.this, "Video carregado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdStarted() {
                Toast.makeText(MainActivity.this, "Propaganda iniciou", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVideoStarted() {
                Toast.makeText(MainActivity.this, "Video começando", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVideoEnded() {
                Toast.makeText(MainActivity.this, "Video chegou ao final", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {
                Toast.makeText(MainActivity.this, "Erro ao recuperar eventos de carregamento!", Toast.LENGTH_SHORT).show();
            }
        };

        playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {
                Toast.makeText(MainActivity.this, "Video executando", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPaused() {
                Toast.makeText(MainActivity.this, "Video pausado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopped() {
                Toast.makeText(MainActivity.this, "Video parado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBuffering(boolean b) {
                Toast.makeText(MainActivity.this, "Video pré-carregando", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSeekTo(int i) {
                Toast.makeText(MainActivity.this, "Movimentando a SeeekBar", Toast.LENGTH_SHORT).show();
            }
        };
        youTubePlayerView = findViewById(R.id.viewYoutubePlayer);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean foiRestaurado) {
        //youTubePlayer.loadVideo("n1W-KiHzprk");//Executa automaticamente o vídeo
        //youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        if(!foiRestaurado){
            //youTubePlayer.cueVideo("n1W-KiHzprk");//Não Executa automaticamente o vídeo o usuário precisa clicar
            youTubePlayer.cuePlaylist("PLWz5rJ2EKKc8SmtMNw34wvYkqj45rV1d3");
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Erro ao iniciar o player!" + youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
    }
}