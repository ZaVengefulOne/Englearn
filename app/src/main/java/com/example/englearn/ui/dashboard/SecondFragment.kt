package com.example.englearn.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.englearn.R
import com.example.englearn.databinding.FragmentSecondBinding
import com.example.englearn.ui.notifications.ThirdFragment

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val secondFragmentViewModel =
            ViewModelProvider(this).get(SecondFragmentViewModel::class.java)

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonView: Button = binding.forwardButton
        secondFragmentViewModel.text.observe(viewLifecycleOwner) {
            buttonView.text = it
        }
        binding.forwardButton.setOnClickListener {
            val thirdFragment = ThirdFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.nav_host_fragment_activity_main, thirdFragment)
                .remove(SecondFragment())
                .addToBackStack(null)
                .commit()

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}