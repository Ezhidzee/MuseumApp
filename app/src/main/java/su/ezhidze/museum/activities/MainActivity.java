package su.ezhidze.museum.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import su.ezhidze.museum.R;
import su.ezhidze.museum.adapters.MainActivityViewPagerFragmentsAdapter;
import su.ezhidze.museum.databinding.ActivityMainBinding;
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