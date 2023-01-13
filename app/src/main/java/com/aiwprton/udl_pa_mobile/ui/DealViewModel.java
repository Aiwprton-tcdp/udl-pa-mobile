package com.aiwprton.udl_pa_mobile.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aiwprton.udl_pa_mobile.models.DealModel;
import com.aiwprton.udl_pa_mobile.services.DealService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class DealViewModel extends ViewModel {
    private final MutableLiveData<DealModel> deal;


    public DealViewModel(int id) throws IOException, ExecutionException, InterruptedException {
        deal = new MutableLiveData<>();
        deal.setValue(GetData(id));
    }


    public LiveData<DealModel> getDeals() {
        return deal;
    }

    private DealModel GetData(int id) throws IOException, ExecutionException, InterruptedException {
        return DealService.GetDealData(id);
    }
}