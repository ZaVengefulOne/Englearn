package com.example.englearn.ui.Fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.englearn.R
import com.example.englearn.databinding.FragmentRhymeBinding
import com.example.englearn.ui.ViewModels.RhymeFragmentViewModel
import com.squareup.picasso.Picasso


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
        val LinkText: EditText = binding.editTextText
        val LinkButton: Button = binding.getImageButton
        val TargetImage: ImageView = binding.imageView3
//        rhymeFragmentViewModel.text.observe(viewLifecycleOwner) {
//            buttonView.text = it
//        }
//        val textView: TextView = binding.textView
//        secondFragmentViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        LinkButton.setOnClickListener {
            val url = LinkText.text.toString()
            val Network = Thread {
                Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.rhymes_icon)
                    .error(R.drawable.baseline_account_circle_24)
                    .into(TargetImage)
            }
            val Disk = Thread {
                val image_uri = Uri.parse(url)
            }
            Network.start()
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}