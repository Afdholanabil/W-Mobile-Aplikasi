package com.example.recyclickprojek.Fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recyclickprojek.API.APIRequestData;
import com.example.recyclickprojek.API.serverRetrofit;
import com.example.recyclickprojek.Adapter.AdapterBarang;
import com.example.recyclickprojek.Model.ModelDataBarang;
import com.example.recyclickprojek.Model.responsDataBarang;
import com.example.recyclickprojek.R;
import com.example.recyclickprojek.databinding.FragmentDataBarangBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataBarangFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataBarangFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rcycview;
    private RecyclerView.Adapter rvadapter;
    private RecyclerView.LayoutManager lmdata;
    private List<ModelDataBarang> listdata = new ArrayList<>();

    public DataBarangFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataBarangFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataBarangFragment newInstance(String param1, String param2) {
        DataBarangFragment fragment = new DataBarangFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDataBarangBinding br = DataBindingUtil.inflate(inflater, R.layout.fragment_data_barang, container,false);
        rcycview = br.rcyBarang;
        lmdata = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        rcycview.setLayoutManager(lmdata);
        retriveData();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_barang, container, false);
    }

    public void retriveData() {
        APIRequestData ard = serverRetrofit.koneksiRetrofit().create(APIRequestData.class);
        Call<responsDataBarang> tampilkanData = ard.ardRetriveBarang();

        tampilkanData.enqueue(new Callback<responsDataBarang>() {
            @Override
            public void onResponse(Call<responsDataBarang> call, Response<responsDataBarang> response) {
                int kode = response.body().getKode();
                String message = response.body().getMessage();
                listdata = response.body().getData();
                rvadapter = new AdapterBarang(getContext(), listdata);
                rcycview.setAdapter(rvadapter);
                rvadapter.notifyDataSetChanged();

                Toast.makeText(getActivity(), "Kode "+kode +"| pesan "+message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<responsDataBarang> call, Throwable t) {
                Toast.makeText(getActivity(), "terdapat kesalah : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}