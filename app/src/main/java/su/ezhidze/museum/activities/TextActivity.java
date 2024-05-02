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
import su.ezhidze.museum.utilities.Constants;
import su.ezhidze.museum.utilities.PreferenceManager;


public class TextActivity extends AppCompatActivity {

    private ActivityTextBinding binding;

    private PreferenceManager preferenceManager;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTextBinding.inflate(getLayoutInflater());
        setAnimation();
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding.textData.setMovementMethod(new ScrollingMovementMethod());

        switch (preferenceManager.getString(Constants.EXPO_ID)) {
            case "1":
                binding.textData.setText(R.string.expo1Text);
                binding.textName.setText(R.string.expo1Name);
                break;
            case "2":
                binding.textData.setText(R.string.expo2Text);
                binding.textName.setText(R.string.expo2Name);
                break;
            case "3":
                binding.textData.setText(R.string.expo3Text);
                binding.textName.setText(R.string.expo3Name);
                break;
            case "4":
                binding.textData.setText(R.string.expo4Text);
                binding.textName.setText(R.string.expo4Name);
                break;
            case "5":
                binding.textData.setText(R.string.expo5Text);
                binding.textName.setText(R.string.expo5Name);
                break;
            case "6":
                binding.textData.setText(R.string.expo6Text);
                binding.textName.setText(R.string.expo6Name);
                break;
            case "7":
                binding.textData.setText(R.string.expo7Text);
                binding.textName.setText(R.string.expo7Name);
                break;
            case "8":
                StringBuilder termsString = new StringBuilder();
                BufferedReader reader;
                try {
                    reader = new BufferedReader(
                            new InputStreamReader(getResources().openRawResource(R.raw.expo8_text)));

                    String str;
                    while ((str = reader.readLine()) != null) {
                        termsString.append(str + '\n');
                    }

                    reader.close();
                    binding.textData.setText(termsString.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                binding.textName.setText(R.string.expo8Name);
                break;
            case "9":
                binding.textData.setText(R.string.expo9Text);
                binding.textName.setText(R.string.expo9Name);
                break;
            case "10":
                binding.textData.setText(R.string.expo10Text);
                binding.textName.setText(R.string.expo10Name);
                break;
            case "11":
                binding.textData.setText(R.string.expo11Text);
                binding.textName.setText(R.string.expo11Name);
                break;
            case "12":
                binding.textData.setText(R.string.expo12Text);
                binding.textName.setText(R.string.expo12Name);
                break;
        }

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

            switch (preferenceManager.getString(Constants.EXPO_ID)) {
                case "1":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s1);
                    break;
                case "2":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s2);
                    break;
                case "3":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s3);
                    break;
                case "4":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s4);
                    break;
                case "5":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s5);
                    break;
                case "6":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s6);
                    break;
                case "7":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s7);
                    break;
                case "8":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s8);
                    break;
                case "9":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s9);
                    break;
                case "10":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s10);
                    break;
                case "11":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s11);
                    break;
                case "12":
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s12);
                    break;
            }
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
