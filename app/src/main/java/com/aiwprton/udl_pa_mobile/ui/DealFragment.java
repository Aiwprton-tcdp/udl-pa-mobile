package com.aiwprton.udl_pa_mobile.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aiwprton.udl_pa_mobile.R;
import com.aiwprton.udl_pa_mobile.ui.deals.DealsViewModel;

public class DealFragment extends Fragment {
    private static DealsViewModel dealVM;
//    private DealViewModel mViewModel;

    public static DealFragment newInstance() {
        return new DealFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_deal, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(DealViewModel.class);
        // TODO: Use the ViewModel
    }

}