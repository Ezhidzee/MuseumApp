package su.ezhidze.museum.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

//import su.ezhidze.enigma.fragments.ChatsFragment;
import su.ezhidze.museum.fragments.AppInfoFragment;
import su.ezhidze.museum.fragments.ContactsFragment;
import su.ezhidze.museum.fragments.MapFragment;
import su.ezhidze.museum.fragments.MuseumInfoFragment;
import su.ezhidze.museum.utilities.Constants;

public class MainActivityViewPagerFragmentsAdapter extends FragmentStateAdapter {

    public MainActivityViewPagerFragmentsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new MapFragment();
            case 1:
                return new MuseumInfoFragment();
            case 2:
                return new ContactsFragment();
            case 3:
                return new AppInfoFragment();
            default:
                return new MapFragment();
        }
    }

    @Override
    public int getItemCount() {
        return Constants.TITLES.length;
    }
}
