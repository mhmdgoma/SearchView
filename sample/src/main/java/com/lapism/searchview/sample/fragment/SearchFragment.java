package com.lapism.searchview.sample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lapism.searchview.sample.R;
import com.lapism.searchview.sample.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SearchFragment extends Fragment {

    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String[] strings = {
                getString(R.string.apps),
                getString(R.string.movies),
                getString(R.string.updates),
                getString(R.string.installed),
                getString(R.string.library),
                getString(R.string.beta)
        };

        List<String> list = new ArrayList<>(30);
        Random random = new Random();
        while (list.size() < 30) {
            list.add(strings[random.nextInt(strings.length)]);
        }

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(list));
        return recyclerView;
    }

}