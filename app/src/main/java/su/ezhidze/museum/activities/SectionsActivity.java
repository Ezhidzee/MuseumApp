package su.ezhidze.museum.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import su.ezhidze.museum.R;
import su.ezhidze.museum.adapters.SectionsAdapter;
import su.ezhidze.museum.databinding.ActivitySectionsBinding;
import su.ezhidze.museum.listeners.SectionListener;
import su.ezhidze.museum.models.Section;
import su.ezhidze.museum.utilities.Constants;
import su.ezhidze.museum.utilities.PreferenceManager;

public class SectionsActivity extends AppCompatActivity implements SectionListener {

    private ActivitySectionsBinding binding;

    private PreferenceManager preferenceManager;

    private SectionsAdapter sectionsAdapter;

    private List<Section> sectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySectionsBinding.inflate(getLayoutInflater());
        setAnimation();
        setContentView(binding.getRoot());

        init();
        setTitle();
    }

    private void init() {
        preferenceManager = new PreferenceManager(getApplicationContext());
        switch (preferenceManager.getString(Constants.EXPO_ID)) {
            case "6":
                sectionList = Constants.expo6Sections;
                break;
            case "7":
                sectionList = Constants.expo7Sections;
                break;
            case "8":
                sectionList = Constants.expo8Sections;
                break;
            case "10":
                sectionList = Constants.expo10Sections;
                break;
        }
        sectionsAdapter = new SectionsAdapter(sectionList, this);
        binding.recentConversationUsersRecyclerView.setAdapter(sectionsAdapter);
        binding.recentConversationUsersRecyclerView.setVisibility(View.VISIBLE);
    }

    private void setTitle() {
        switch (preferenceManager.getString(Constants.EXPO_ID)) {
            case "6":
                binding.title.setText(R.string.expo6Name);
                break;
            case "7":
                binding.title.setText(R.string.expo7Name);
                break;
            case "8":
                binding.title.setText(R.string.expo8Name);
                break;
            case "10":
                binding.title.setText(R.string.expo10Name);
                break;
        }
        binding.imageBack.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void onSectionClicked(Section section) {
        Intent i = new Intent(getApplicationContext(), TextActivity.class);
        i.putExtra(Constants.KEY_SECTION, section);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(i, options.toBundle());
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
}