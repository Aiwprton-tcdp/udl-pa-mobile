package com.aiwprton.udl_pa_mobile.ui.deals;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aiwprton.udl_pa_mobile.R;
import com.aiwprton.udl_pa_mobile.databinding.FragmentDealsBinding;
import com.aiwprton.udl_pa_mobile.models.Deal;
import com.aiwprton.udl_pa_mobile.models.DealsModel;
import com.aiwprton.udl_pa_mobile.ui.DealFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DealsFragment extends Fragment implements DealsListAdapter.ItemClickListener {
    private FragmentDealsBinding binding;
    private static DealsViewModel dealsVM;
    DealsListAdapter adapter;

    public static DealsFragment newInstance() {
        return new DealsFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SimpleDateFormat")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        dealsVM = new ViewModelProvider(this).get(DealsViewModel.class);
        binding = FragmentDealsBinding.inflate(inflater, container, false);

        ArrayList<Deal> deals = new ArrayList<>();

        loadDeals().forEach((DealsModel d) -> {
            if (d.Deals.length == 0) return;
            deals.addAll(Arrays.asList(d.Deals));
        });

        RecyclerView dn = binding.dealsNames.findViewById(R.id.deals_names);
        dn.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DealsListAdapter(getContext(), deals);
        adapter.setClickListener(this);
        dn.setAdapter(adapter);

        return binding.getRoot();
    }

    private static List<DealsModel> loadDeals() {
        return dealsVM.getDeals().getValue();
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("ID", adapter.getItem(position).ID);

        AppCompatActivity act = (AppCompatActivity)view.getContext();
        DealFragment df = new DealFragment();
        act.getSupportFragmentManager().beginTransaction()
                .replace(R.id.deal_show, df)
                .addToBackStack(null).commit();

//        Fragment fragment = new DealFragment();
//        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.navigation_deals, fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();

//        Intent dealActivity = new Intent(getContext(), DealFragment.class);
//        startActivity(dealActivity);
    }
}