package com.example.vetapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SoruSorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SoruSorFragment extends Fragment {


    public SoruSorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SoruSorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SoruSorFragment newInstance(String param1, String param2) {
        SoruSorFragment fragment = new SoruSorFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_soru_sor, container, false);
    }
}