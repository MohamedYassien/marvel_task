package com.example.marveltask.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.marveltask.R;
import com.example.marveltask.repository.model.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private List<Character> characters = new ArrayList<>();

    public void submitList(List<Character> characterList) {
        characters = characterList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.name.setText(character.getName());
        String secureUrl = character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension().replace("http://", "https://");
        Glide.with(holder.image.getContext()).load(secureUrl).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    static class CharacterViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        CharacterViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.character_name);
            image = itemView.findViewById(R.id.character_image);
        }
    }
}

