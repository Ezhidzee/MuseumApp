package su.ezhidze.museum.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import su.ezhidze.museum.databinding.FragmentMuseumInfoBinding;
import su.ezhidze.museum.utilities.PreferenceManager;

public class MuseumInfoFragment extends Fragment {

    private FragmentMuseumInfoBinding binding;

    private PreferenceManager preferenceManager;

    public MuseumInfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMuseumInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        preferenceManager = new PreferenceManager(getActivity().getApplicationContext());
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
