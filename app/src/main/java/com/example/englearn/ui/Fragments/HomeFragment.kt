package com.example.englearn.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.englearn.R
import com.example.englearn.databinding.FragmentHomeBinding
import com.example.englearn.ui.ViewModels.HomeViewModel
import androidx.navigation.Navigation

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonView: Button = binding.forwardButton
        homeViewModel.buttonText.observe(viewLifecycleOwner) {
            buttonView.text = it
        }
        val welcometextView: TextView = binding.welcomeText
        homeViewModel.welcomeText.observe(viewLifecycleOwner){
            welcometextView.text = it
        }
        binding.forwardButton.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_home_to_rhyme) };

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}