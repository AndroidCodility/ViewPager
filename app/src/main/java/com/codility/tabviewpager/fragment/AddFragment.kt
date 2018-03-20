package com.codility.tabviewpager.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codility.tabviewpager.R
import kotlinx.android.synthetic.main.add_fragment.view.*

/**
 * Created by Govind on 3/20/2018.
 */
class AddFragment : Fragment() {
    private var textFragment = ""

    companion object {
        fun newInstance(text: String): AddFragment {
            val fragment = AddFragment()
            val bundle = Bundle()
            bundle.putString("AddFragment", text)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textFragment = arguments?.get("AddFragment").toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.tvFragment.text = textFragment
    }
}