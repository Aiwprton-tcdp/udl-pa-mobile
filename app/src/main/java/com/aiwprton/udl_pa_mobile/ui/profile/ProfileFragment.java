package com.aiwprton.udl_pa_mobile.ui.profile;

import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.aiwprton.udl_pa_mobile.ui.login.LoginActivity;
import com.aiwprton.udl_pa_mobile.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private ProfileViewModel profileVM;
    public TextView textFIO;
    public Button settingsButton;
    public Button promotionsButton;
    public Button faqButton;
    public Button contactsButton;
    public Button affiliateProgramButton;
    public Button logoutButton;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        profileVM = new ViewModelProvider(this).get(ProfileViewModel.class);
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        textFIO = binding.textProfile;
        settingsButton = binding.settings;
        promotionsButton = binding.promotions;
        faqButton = binding.faq;
        contactsButton = binding.contacts;
        affiliateProgramButton = binding.affiliateProgram;
        logoutButton = binding.logout;

        profileVM.getText().observe(getViewLifecycleOwner(), textFIO::setText);

        settingsButton.setOnClickListener(v -> OpenSettings());
        promotionsButton.setOnClickListener(v -> OpenPromotions());
        faqButton.setOnClickListener(v -> OpenFAQ());
        contactsButton.setOnClickListener(v -> OpenContacts());
        affiliateProgramButton.setOnClickListener(v -> OpenAffiliateProgram());
        logoutButton.setOnClickListener(v -> LogOut());

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void OpenSettings() {
    }

    private void OpenPromotions() {
    }

    private void OpenFAQ() {
    }

    private void OpenContacts() {
    }

    private void OpenAffiliateProgram() {
    }

    private void LogOut() {
        profileVM.LogOut();

        Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
//        loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        getActivity().finish();
//        App.finishMainActivity();
    }
}