package com.example.marveltask.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marveltask.MarvelUtils;
import com.example.marveltask.R;
import com.example.marveltask.viewmodel.CharacterViewModel;

public class CharacterListFragment extends Fragment {

    private CharacterViewModel viewModel;
    private RecyclerView recyclerView;
    private CharacterAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_list, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CharacterAdapter();
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);

        String publicKey = "5ffa900afac21b93ffddf914ce05df8c";
        String privateKey = "680bca73984de09c57a1d9152c397fb377d4b006";
        long ts = System.currentTimeMillis();
        String hash = MarvelUtils.generateHash(ts + privateKey + publicKey);

        viewModel.fetchCharacters(20, 0, publicKey, hash, ts);

        viewModel.getCharacters().observe(getViewLifecycleOwner(), characters -> {
            adapter.submitList(characters);
        });

        return view;
    }
}

