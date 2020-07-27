package com.edisondeveloper.petagram.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edisondeveloper.petagram.Adapters.PerfilAdapter;
import com.edisondeveloper.petagram.Model.PerfilMascota;
import com.edisondeveloper.petagram.R;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    private RecyclerView recyclerView;

    public PerfilFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.perfil_fragment, container, false);
        ArrayList<PerfilMascota> list = new ArrayList<>();
        list.add(new PerfilMascota(R.drawable.matias01, 5));
        list.add(new PerfilMascota(R.drawable.matias02, 4));
        list.add(new PerfilMascota(R.drawable.matias03, 7));
        list.add(new PerfilMascota(R.drawable.matias04, 9));
        list.add(new PerfilMascota(R.drawable.matias05, 14));
        list.add(new PerfilMascota(R.drawable.matias06, 10));
        list.add(new PerfilMascota(R.drawable.matias07, 3));
        list.add(new PerfilMascota(R.drawable.matias08, 19));
        list.add(new PerfilMascota(R.drawable.matias09, 2));
        recyclerView = view.findViewById(R.id.recyclerViewPerfil);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        PerfilAdapter adapter = new PerfilAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);
        return view;
    }
}