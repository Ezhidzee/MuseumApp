package su.ezhidze.museum.activities;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.tabs.TabLayoutMediator;

import su.ezhidze.museum.adapters.MainActivityViewPagerFragmentsAdapter;
import su.ezhidze.museum.databinding.ActivityMainBinding;
import su.ezhidze.museum.models.Section;
import su.ezhidze.museum.utilities.Constants;
import su.ezhidze.museum.utilities.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private ActivityMainBinding binding;

    private MainActivityViewPagerFragmentsAdapter viewPagerFragmentsAdapter;

    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setAnimation();
        setContentView(binding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        binding.toolbar.setTitle("Музей блокады Ленинграда");

        preferenceManager = new PreferenceManager(getApplicationContext());

        viewPagerFragmentsAdapter = new MainActivityViewPagerFragmentsAdapter(this);
        binding.viewPager.setAdapter(viewPagerFragmentsAdapter);
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
            tab.setText(Constants.TITLES[position]);
        }).attach();
        if (savedInstanceState == null) init();
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

    private void init() {
        for (int i = 0; i < Constants.EXPO6_SECTIONS.size(); ++i)
            Constants.expo6Sections.add(new Section(getResources().getString(Constants.EXPO6_SECTIONS.get(i).component1()), getResources().getString(Constants.EXPO6_SECTIONS.get(i).component2()), Constants.EXPO6_AUDIOS.get(i)));
        for (int i = 0; i < Constants.EXPO7_SECTIONS.size(); ++i)
            Constants.expo7Sections.add(new Section(getResources().getString(Constants.EXPO7_SECTIONS.get(i).component1()), getResources().getString(Constants.EXPO7_SECTIONS.get(i).component2()), Constants.EXPO7_AUDIOS.get(i)));
        for (int i = 0; i < Constants.EXPO8_SECTIONS.size(); ++i)
            Constants.expo8Sections.add(new Section(getResources().getString(Constants.EXPO8_SECTIONS.get(i).component1()), getResources().getString(Constants.EXPO8_SECTIONS.get(i).component2()), Constants.EXPO8_AUDIOS.get(i)));
        for (int i = 0; i < Constants.EXPO9_SECTIONS.size(); ++i)
            Constants.expo9Sections.add(new Section(getResources().getString(Constants.EXPO9_SECTIONS.get(i).component1()), getResources().getString(Constants.EXPO9_SECTIONS.get(i).component2()), Constants.EXPO9_AUDIOS.get(i)));
        for (int i = 0; i < Constants.EXPO10_SECTIONS.size(); ++i)
            Constants.expo10Sections.add(new Section(getResources().getString(Constants.EXPO10_SECTIONS.get(i).component1()), getResources().getString(Constants.EXPO10_SECTIONS.get(i).component2()), Constants.EXPO10_AUDIOS.get(i)));
    }
}