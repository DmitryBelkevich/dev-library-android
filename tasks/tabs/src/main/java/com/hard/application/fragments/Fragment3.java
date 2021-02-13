package com.hard.application.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hard.application.R;

public class Fragment3 extends Fragment {
    private static final String TITLE = "title";

    private String title;

    public Fragment3() {

    }

    public static Fragment3 newInstance(String title) {
        Fragment3 fragment = new Fragment3();

        Bundle bundle = new Bundle();

        bundle.putString(TITLE, title);

        fragment.setArguments(bundle);

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
        return inflater.inflate(R.layout.fragment_3, container, false);
    }
}