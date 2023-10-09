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
import com.example.englearn.data.API.ApiService
import com.example.englearn.databinding.FragmentTheoryBinding
import com.example.englearn.ui.ViewModels.TheoryFragmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jsoup.Jsoup
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

//        val buttonView: Button = binding.backButton
//        theoryFragmentViewModel.text.observe(viewLifecycleOwner) {
//            buttonView.text = it
//        }
//        binding.backButton.setOnClickListener {
//            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_theory_to_home) }
//        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val articleText: TextView = binding.articleText
        val articleTitleText: TextView = binding.ArticleNameText
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://nsaturnia.ru/").client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)


        val getArticleButton: Button = binding.getInfoButton
        getArticleButton.setOnClickListener {
//            apiService.getArticle().enqueue(object : Callback<String> {
//                override fun onResponse(call: Call<String>, response: Response<String>) {
//                    if (response.isSuccessful) {
//                        val html = response.body()
//                        if (html != null) {
            val gfgThread = Thread {
                try {
                    val document =
                        Jsoup.connect("https://nsaturnia.ru/kak-pisat-stixi/vvodnaya-lekciya/").get();
                    val Titletext = document.title()
//                        val ArticleText = document.getElementsContainingOwnText("пушкинских ")
//                    val ArticleText = document.getElementsByClass("nativerent-content-integration").text()
                    val ArticleText = document.getElementsByClass("article-container post").text()
                    articleText.text = ArticleText
                    articleTitleText.text = Titletext
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            gfgThread.start()


//                        } else {
//                            articleText.text = "Ошибка! Статья не найдена!"
//                        }
//                    } else {
//                        articleText.text = "Ошибка! Статья не найдена!"
//                    }
//                }
//
//                override fun onFailure(call: Call<String>, t: Throwable) {
//                    articleText.text = "Ошибка! Нет подключения к сети!"
//                }
//            })
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}