package com.example.englearn.ui.Fragments

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.englearn.data.API.ApiService
import com.example.englearn.databinding.FragmentTheoryBinding
import com.example.englearn.data.DI.SumUseCase
import com.example.englearn.ui.ViewModels.TheoryFragmentViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jsoup.Jsoup
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


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
        val theoryFragmentViewModel =
            ViewModelProvider(this).get(TheoryFragmentViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        val articleText: TextView = binding.articleText
        val articleTitleText: TextView = binding.ArticleNameText
        val getArticleButton: Button = binding.getInfoButton
        val interceptor = HttpLoggingInterceptor()
        var articlesAmount: Int = 0
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://nsaturnia.ru/").client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        getArticleButton.setOnClickListener {
//            apiService.getArticle().enqueue(object : Callback<String> {
//                override fun onResponse(call: Call<String>, response: Response<String>) {
//                    if (response.isSuccessful) {
//                        val html = response.body()
//                        if (html != null) {
            val gfgThread = Thread {
                try {
                    val document =
                        Jsoup.connect("https://nsaturnia.ru/kak-pisat-stixi/vvodnaya-lekciya/")
                            .get();
                    val Titletext = document.title()
                    val ArticleText = document.getElementsByClass("article-container post").text()
                    articleText.text = ArticleText
                    articleTitleText.text = Titletext
                    articleText.movementMethod = ScrollingMovementMethod();
                    articlesAmount += 1
//                    theoryFragmentViewModel.insertNewArticle(articlesAmount,Titletext, ArticleText,true)
                } catch (e: Exception) {
                    articleText.text = "Ошибка! Статья не найдена!"
                    articleTitleText.text = "Ошибка! Статья не найдена!"
                }
            }
            gfgThread.start()
    }


//        val scrollUpButton: Button = binding.scrollUp
//        val scrollDownButton: Button = binding.scrollDown
//        val ArticleScrollView: ScrollView = binding.scrollView2
//        scrollUpButton.setOnClickListener {
//            ArticleScrollView.scrollBy(0, 20)
//        }
//        scrollDownButton.setOnClickListener {
//            ArticleScrollView.scrollBy(0, -20)
//        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}