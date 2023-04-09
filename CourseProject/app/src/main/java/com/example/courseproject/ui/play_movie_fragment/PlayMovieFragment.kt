package com.example.courseproject.ui.play_movie_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.courseproject.databinding.FragmentPlayMovieBinding


const val PLAY_MOVIE = "play_movie"

class PlayMovieFragment : Fragment() {
    private var _binding: FragmentPlayMovieBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(bundle: Bundle): PlayMovieFragment {
            val fragment = PlayMovieFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString(PLAY_MOVIE) ?: ""
        if (url != "") {
            val webView = binding.webView
            val settings = webView.settings
            webView.loadUrl(url)
            settings.apply {
                javaScriptEnabled = true
                setSupportZoom(true)
                builtInZoomControls = true
            }
        }
    }
}
