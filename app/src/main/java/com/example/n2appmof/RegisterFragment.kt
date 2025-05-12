package com.example.n2appmof;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    EditText  createUserEmail, createUserName, createUserTel, createUserPassword, createUserValidPass;

    Button createUserButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);


        createUserEmail = view.findViewById(R.id.createuserEmail);
        createUserName = view.findViewById(R.id.createUserUsername);
        createUserTel = view.findViewById(R.id.createUserTel);
        createUserPassword = view.findViewById(R.id.createUserPassword);
        createUserValidPass = view.findViewById(R.id.createUserValidPass);

        createUserButton = view.findViewById(R.id.createUserButton);

        createUserButton.setOnClickListener(this);

        return view;


    }

    @Override
    public void onClick(View v) {
        String[] values = {
                createUserEmail.getText().toString(),
                createUserName.getText().toString(),
                createUserTel.getText().toString(),
                createUserPassword.getText().toString(),
                createUserValidPass.getText().toString(),
        };

        String [] messages = {
                "O campo *E-mail* deve ser preenchido!",
                "O campo *Nome do usuário* deve ser preenchido!",
                "O campo *Telefone* deve ser preenchido!",
                "O campo *Senha* deve ser preenchido!",
                "O campo *Confirme sua senha* deve ser preenchido!"
        };

        for (int i = 0; i < values.length; i++) {
            if (values[i].isEmpty()){
                Toast.makeText(getContext(), messages[i], Toast.LENGTH_SHORT).show();
                return;
            }
        }
        if (!values[3].equals(values[4])) {
            Toast.makeText(requireContext(), "As senhas não coincidem!", Toast.LENGTH_LONG).show();
            return;
        }

        RegisterController controller = new RegisterController(requireContext());
        String result = controller.insertData(

                values[0],
                values[1],
                values[2],
                values[3]
        );
        dismiss();
    }
}
