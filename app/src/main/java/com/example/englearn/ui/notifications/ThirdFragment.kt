package com.example.englearn.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.englearn.R
import com.example.englearn.databinding.FragmentThirdBinding
import com.example.englearn.ui.dashboard.SecondFragment
import com.example.englearn.ui.home.HomeFragment

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val thirdFragmentViewModel =
            ViewModelProvider(this).get(ThirdFragmentViewModel::class.java)

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonView: Button = binding.backButton
        thirdFragmentViewModel.text.observe(viewLifecycleOwner) {
            buttonView.text = it
        }
        binding.backButton.setOnClickListener {
            val homeFragment = HomeFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.nav_host_fragment_activity_main, homeFragment)
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