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
import com.example.englearn.databinding.FragmentRhymeBinding
import com.example.englearn.ui.ViewModels.RhymeFragmentViewModel

class RhymeFragment : Fragment() {

    private var _binding: FragmentRhymeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rhymeFragmentViewModel =
            ViewModelProvider(this).get(RhymeFragmentViewModel::class.java)

        _binding = FragmentRhymeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonView: Button = binding.forwardButton
        rhymeFragmentViewModel.text.observe(viewLifecycleOwner) {
            buttonView.text = it
        }
//        val textView: TextView = binding.textView
//        secondFragmentViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        binding.forwardButton.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_rhyme_to_theory) };
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}