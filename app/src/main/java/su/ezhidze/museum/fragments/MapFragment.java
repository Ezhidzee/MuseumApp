package su.ezhidze.museum.fragments;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import su.ezhidze.museum.R;
import su.ezhidze.museum.activities.TextActivity;
import su.ezhidze.museum.databinding.FragmentMapBinding;
import su.ezhidze.museum.utilities.Constants;
import su.ezhidze.museum.utilities.PreferenceManager;


public class MapFragment extends Fragment {

    private FragmentMapBinding binding;

    private PreferenceManager preferenceManager;

    private Boolean mapId = false;

    public MapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        setClickListeners();
    }

    private void init() {
        preferenceManager = new PreferenceManager(getActivity().getApplicationContext());
        Animation inAnimation = new AlphaAnimation(0, 1);
        inAnimation.setDuration(800);
        Animation outAnimation = new AlphaAnimation(1, 0);
        outAnimation.setDuration(800);
        binding.imageSwitcher.setInAnimation(inAnimation);
        binding.imageSwitcher.setOutAnimation(outAnimation);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setClickListeners() {
        binding.imageSwitcher.setOnTouchListener((view, motionEvent) -> {
            ImageView map = (ImageView) binding.imageSwitcher.getCurrentView();
            int viewX = (int) motionEvent.getX();
            int viewY = (int) motionEvent.getY();

            int viewWidth = map.getWidth();
            int viewHeight = map.getHeight();

            Bitmap image = ((BitmapDrawable) map.getDrawable()).getBitmap();

            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();

            int imageX = (int) ((float) viewX * ((float) imageWidth / (float) viewWidth));
            int imageY = (int) ((float) viewY * ((float) imageHeight / (float) viewHeight));

            int currPixel = image.getPixel(imageX, imageY);

            if (Constants.EXPOs_ID.get(String.format("#%02x%02x%02x", Color.red(currPixel), Color.green(currPixel), Color.blue(currPixel)).toUpperCase()) != null) {
                preferenceManager.putString(Constants.EXPO_ID, Constants.EXPOs_ID.get(String.format("#%02x%02x%02x", Color.red(currPixel), Color.green(currPixel), Color.blue(currPixel)).toUpperCase()));
                Intent i = new Intent(getContext(), TextActivity.class);
                if (Build.VERSION.SDK_INT > 20) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity());
                    startActivity(i, options.toBundle());
                } else {
                    startActivity(i);
                }
            }

            Log.d("Coordinates", String.format("#%02x%02x%02x", Color.red(currPixel), Color.green(currPixel), Color.blue(currPixel)).toUpperCase() + " Pixel is: " + currPixel);

            return false;
        });

        binding.fabFloor.setOnClickListener(view -> {
            if (!mapId) {
                binding.fabFloor.setImageResource(R.drawable.baseline_looks_one_24);
                binding.imageSwitcher.showNext();
                mapId = true;
            } else {
                binding.fabFloor.setImageResource(R.drawable.baseline_looks_two_24);
                binding.imageSwitcher.showNext();
                mapId = false;
            }
        });
    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}