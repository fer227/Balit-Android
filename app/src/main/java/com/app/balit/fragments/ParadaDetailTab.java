package com.app.balit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.balit.LineaDetail;
import com.app.balit.ParadaDetail;
import com.app.balit.R;
import com.app.balit.adapters.ListAdapterParada;
import com.app.balit.api.ShippingMicroserviceService;
import com.app.balit.models.Conexion;
import com.app.balit.models.Linea;
import com.app.balit.models.Parada;
import com.app.balit.utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParadaDetailTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParadaDetailTab extends Fragment {
    static ListAdapterParada listAdapterParada;
    ArrayList<Conexion> conexions = new ArrayList<Conexion>();
    String numeroParada;
    String nombreParada;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ParadaDetailTab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ParadaDetailTab.
     */
    // TODO: Rename and change types and number of parameters
    public static ParadaDetailTab newInstance(String param1, String param2) {
        ParadaDetailTab fragment = new ParadaDetailTab();
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
        nombreParada = activity.getNombreParada();

        ShippingMicroserviceService.getInstance().getParada(numeroParada).enqueue(new Callback<Parada>() {
            @Override
            public void onResponse(Call<Parada> call, Response<Parada> response) {
                conexions.clear();
                conexions.addAll(response.body().getConexiones());
                listAdapterParada.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Parada> call, Throwable t) {
                Utils.enviarToast("Error al intentar recibir la información de la parada", getContext());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parada_detail_tab, container, false);

        listAdapterParada = new ListAdapterParada(conexions, getContext());
        RecyclerView recyclerView = view.findViewById(R.id.lista_paradas_tiempo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapterParada);

        TextView titulo = view.findViewById(R.id.titulo_parada_detail);
        titulo.setText(nombreParada);

        return view;
    }
}