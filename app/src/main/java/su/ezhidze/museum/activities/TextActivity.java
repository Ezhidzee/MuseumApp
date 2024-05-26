package su.ezhidze.museum.activities;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.transition.Fade;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import su.ezhidze.museum.R;
import su.ezhidze.museum.databinding.ActivityTextBinding;
import su.ezhidze.museum.models.Section;
import su.ezhidze.museum.utilities.Constants;
import su.ezhidze.museum.utilities.PreferenceManager;


public class TextActivity extends AppCompatActivity {

    private ActivityTextBinding binding;

    private PreferenceManager preferenceManager;

    private MediaPlayer mediaPlayer;

    private Section section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTextBinding.inflate(getLayoutInflater());
        setAnimation();
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding.textData.setMovementMethod(new ScrollingMovementMethod());
        section = (Section) getIntent().getSerializableExtra(Constants.KEY_SECTION);
        binding.textName.setText(section.getName());
        binding.textData.setText(section.getText());
        if (section.getImageId() != 0) {
            binding.imageView1.setImageResource(section.getImageId());
            binding.imageView1.setVisibility(View.VISIBLE);
        }
        mediaPlayer = MediaPlayer.create(getApplicationContext(), section.getAudioResourceId());
        setListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    private void setListeners() {
        binding.imageBack.setOnClickListener(view -> onBackPressed());
        binding.fabPlay.setOnClickListener(view -> {
            binding.fabPlay.setVisibility(View.INVISIBLE);
            binding.fabPause.setVisibility(View.VISIBLE);
            binding.fabScroll.setVisibility(View.VISIBLE);
            binding.fabScrollBack.setVisibility(View.VISIBLE);
            mediaPlayer.start();
        });

        binding.fabPause.setOnClickListener(view -> {
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    binding.fabPause.setImageResource(R.drawable.baseline_play_circle_24);
                    mediaPlayer.pause();
                } else {
                    binding.fabPause.setImageResource(R.drawable.baseline_pause_circle_24);
                    mediaPlayer.start();
                }
            }
        });

        binding.fabScroll.setOnClickListener(view -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                if (currentPosition + 10000 <= mediaPlayer.getDuration()) {
                    mediaPlayer.seekTo(currentPosition + 10000);
                } else {
                    mediaPlayer.seekTo(mediaPlayer.getDuration());
                }
            }
        });

        binding.fabScrollBack.setOnClickListener(view -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                if (currentPosition - 10000 >= 0) {
                    mediaPlayer.seekTo(currentPosition - 10000);
                } else {
                    mediaPlayer.seekTo(0);
                }
            }
        });
    }

    public void setAnimation() {
        if (Build.VERSION.SDK_INT > 20) {
            Fade fade = new Fade();
            fade.setDuration(500);
            fade.setInterpolator(new DecelerateInterpolator());
            getWindow().setExitTransition(fade);
            getWindow().setEnterTransition(fade);
        }
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
