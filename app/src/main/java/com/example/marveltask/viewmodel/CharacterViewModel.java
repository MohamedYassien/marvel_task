package com.example.marveltask.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.marveltask.remote.RetrofitClient;
import com.example.marveltask.repository.MarvelApiService;
import com.example.marveltask.repository.model.Character;
import com.example.marveltask.repository.model.MarvelResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends ViewModel {
    private MutableLiveData<List<Character>> characters = new MutableLiveData<>();
    private MarvelApiService apiService;

    public CharacterViewModel() {
        apiService = RetrofitClient.getClient().create(MarvelApiService.class);
    }

    public LiveData<List<Character>> getCharacters() {
        return characters;
    }

    public void fetchCharacters(int limit, int offset, String apiKey, String hash, long ts) {
        apiService.getCharacters(limit, offset, ts, apiKey, hash)
                .enqueue(new Callback<MarvelResponse>() {
                    @Override
                    public void onResponse(Call<MarvelResponse> call, Response<MarvelResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            characters.postValue(response.body().getData().getResults());
                        }
                    }

                    @Override
                    public void onFailure(Call<MarvelResponse> call, Throwable t) {
                        // Handle API failure
                    }
                });
    }
}

