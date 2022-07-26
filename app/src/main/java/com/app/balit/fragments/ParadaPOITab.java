package com.app.balit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.balit.ParadaDetail;
import com.app.balit.R;
import com.app.balit.adapters.ListAdapterPois;
import com.app.balit.api.ShippingMicroserviceService;
import com.app.balit.models.POI;
import com.app.balit.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParadaPOITab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParadaPOITab extends Fragment {
    static ListAdapterPois listAdapterPois;
    ArrayList<POI> pois = new ArrayList<>();
    String numeroParada;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ParadaPOITab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ParadaPOITab.
     */
    // TODO: Rename and change types and number of parameters
    public static ParadaPOITab newInstance(String param1, String param2) {
        ParadaPOITab fragment = new ParadaPOITab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        ParadaDetail activity = (ParadaDetail) getActivity();
        numeroParada = activity.getNumeroParada();

        ShippingMicroserviceService.getInstance().getPOISByParada(numeroParada).enqueue(new Callback<List<POI>>() {
            @Override
            public void onResponse(Call<List<POI>> call, Response<List<POI>> response) {
                pois.clear();
                pois.addAll(response.body());
                System.out.println(response.body());
                System.out.println(numeroParada);
                listAdapterPois.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<POI>> call, Throwable t) {
                Utils.enviarToast("Error al intentar recibir los puntos de interés de esta parada", getContext());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parada_p_o_i_tab, container, false);

        listAdapterPois = new ListAdapterPois(pois, getContext());
        RecyclerView recyclerView = view.findViewById(R.id.lista_pois);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapterPois);

        return view;
    }
}