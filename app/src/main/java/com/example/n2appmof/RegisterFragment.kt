package com.example.n2appmof

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class RegisterFragment : BottomSheetDialogFragment(), View.OnClickListener {
    var createUserEmail: EditText? = null
    var createUserName: EditText? = null
    var createUserTel: EditText? = null
    var createUserPassword: EditText? = null
    var createUserValidPass: EditText? = null

    var createUserButton: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.register_fragment, container, false)


        createUserEmail = view.findViewById(R.id.createuserEmail)
        createUserName = view.findViewById(R.id.createUserUsername)
        createUserTel = view.findViewById(R.id.createUserTel)
        createUserPassword = view.findViewById(R.id.createUserPassword)
        createUserValidPass = view.findViewById(R.id.createUserValidPass)

        createUserButton = view.findViewById(R.id.createUserButton)

        createUserButton?.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View) {
        val values = arrayOf(
            createUserEmail!!.text.toString(),
            createUserName!!.text.toString(),
            createUserTel!!.text.toString(),
            createUserPassword!!.text.toString(),
            createUserValidPass!!.text.toString(),
        )

        val messages = arrayOf(
            "O campo *E-mail* deve ser preenchido!",
            "O campo *Nome do usuário* deve ser preenchido!",
            "O campo *Telefone* deve ser preenchido!",
            "O campo *Senha* deve ser preenchido!",
            "O campo *Confirme sua senha* deve ser preenchido!"
        )

        for (i in values.indices) {
            if (values[i].isEmpty()) {
                Toast.makeText(context, messages[i], Toast.LENGTH_SHORT).show()
                return
            }
        }
        if (values[3] != values[4]) {
            Toast.makeText(requireContext(), "As senhas não coincidem!", Toast.LENGTH_LONG).show()
            return
        }

        val controller = RegisterController(requireContext())
        val result = controller.insertData(
            values[0],
            values[1],
            values[2],
            values[3]
        )
        dismiss()
    }
}
