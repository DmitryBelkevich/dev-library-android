package com.hard.application.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hard.R;

public class Fragment1 extends Fragment {
    private static final String TITLE = "title";

    private String title;

    public Fragment1() {

    }

    public static Fragment1 newInstance(String title) {
        Fragment1 fragment = new Fragment1();

        Bundle args = new Bundle();

        args.putString(TITLE, title);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            title = getArguments().getString(TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
}