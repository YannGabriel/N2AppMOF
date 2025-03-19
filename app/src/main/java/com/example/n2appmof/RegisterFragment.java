package com.example.n2appmof;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.widget.Button;

public class RegisterFragment extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);

        Button createUser = view.findViewById(R.id.createUserButton);
        createUser.setOnClickListener(v -> dismiss());

        return view;
    }
}
