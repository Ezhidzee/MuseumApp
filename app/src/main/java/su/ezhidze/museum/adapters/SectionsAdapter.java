package su.ezhidze.museum.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import su.ezhidze.museum.databinding.ItemContainerSectionBinding;
import su.ezhidze.museum.listeners.SectionListener;
import su.ezhidze.museum.models.Section;

public class SectionsAdapter extends RecyclerView.Adapter<SectionsAdapter.SectionsViewHolder> {

    private List<Section> sections;

    private final SectionListener sectionListener;

    public SectionsAdapter(List<Section> sections, SectionListener sectionListener) {
        this.sections = sections;
        this.sectionListener = sectionListener;
    }

    @NonNull
    @Override
    public SectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SectionsViewHolder(ItemContainerSectionBinding.inflate(LayoutInflater.from(
                parent.getContext()
        ), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SectionsViewHolder holder, int position) {
        holder.setData(sections.get(position));
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }

    class SectionsViewHolder extends RecyclerView.ViewHolder {
        private final ItemContainerSectionBinding binding;

        SectionsViewHolder(ItemContainerSectionBinding itemContainerSectionBinding) {
            super(itemContainerSectionBinding.getRoot());
            binding = itemContainerSectionBinding;
        }

        void setData(Section section) {
            binding.sectionName.setText(section.getName());
            binding.getRoot().setOnClickListener(v -> {
                sectionListener.onSectionClicked(section);
            });
        }
    }
}
