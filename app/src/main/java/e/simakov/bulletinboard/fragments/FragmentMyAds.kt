package e.simakov.bulletinboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import e.simakov.bulletinboard.R

class FragmentMyAds : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_add, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMyAds()
    }
}