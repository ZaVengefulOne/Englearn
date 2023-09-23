package com.example.englearn.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.englearn.R
import com.example.englearn.databinding.FragmentTheoryBinding
import com.example.englearn.ui.ViewModels.TheoryFragmentViewModel

class TheoryFragment : Fragment() {

    private var _binding: FragmentTheoryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val theoryFragmentViewModel =
            ViewModelProvider(this).get(TheoryFragmentViewModel::class.java)

        _binding = FragmentTheoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonView: Button = binding.backButton
        theoryFragmentViewModel.text.observe(viewLifecycleOwner) {
            buttonView.text = it
        }
        binding.backButton.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_theory_to_home) };
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}