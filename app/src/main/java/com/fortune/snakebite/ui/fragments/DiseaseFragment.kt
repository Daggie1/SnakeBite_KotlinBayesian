package com.fortune.snakebite.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fortune.snakebite.CourseRecyclerAdapter
import com.fortune.snakebite.R

/**
 * A simple [Fragment] subclass.
 */
class DiseaseFragment : Fragment() {
        val courseLayoutManager by lazy {
        GridLayoutManager(activity, resources.getInteger(R.integer.diseases_grid_span))
    }

    val courseRecyclerAdapter by lazy {
        CourseRecyclerAdapter(activity!!.applicationContext)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View= inflater.inflate(R.layout.fragment_disease, container, false)
        val recyclerItems=v.findViewById<RecyclerView>(R.id.recyclerItems)
        recyclerItems.layoutManager = courseLayoutManager
        recyclerItems.adapter = courseRecyclerAdapter
        return v;
    }


}
