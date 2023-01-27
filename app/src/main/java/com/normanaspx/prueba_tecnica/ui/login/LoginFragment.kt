package com.normanaspx.prueba_tecnica.ui.login
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import com.normanaspx.prueba_tecnica.databinding.FragmentLoginBinding
import com.normanaspx.prueba_tecnica.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel by activityViewModels<UserViewModel>()
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {


            btnSignUp.setOnClickListener {
                if(username.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
                    val user = User(username.text.toString(), password.text.toString())
                    loginViewModel.addUser(user)
                    Toast.makeText(context, "Usuario creado", Toast.LENGTH_SHORT).show()
                }
            }

            btnLogin.setOnClickListener {
                val user = User(username.text.toString(), password.text.toString())
                checkCredentials(user, it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkCredentials(user: User, view: View){
        loginViewModel.getLoginDetails(user).observe(
            viewLifecycleOwner
        ){
            if(it.isNotEmpty()){
                findNavController(view).navigate(
                    LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                )
            }else{
                Toast.makeText(context, "Credenciales invalidas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}