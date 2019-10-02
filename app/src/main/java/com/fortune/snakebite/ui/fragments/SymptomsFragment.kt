package com.fortune.snakebite.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fortune.snakebite.R
import com.jwhh.notekeeper.SymptomsRecyclerAdapter

/**
 * A simple [Fragment] subclass.
 */
class SymptomsFragment : Fragment() {
    val noteLayoutManager by lazy {
        LinearLayoutManager(activity)
    }




//    val courseLayoutManager by lazy {
//        GridLayoutManager(this, 2)
//    }
//
//    val courseRecyclerAdapter by lazy {
//        CourseRecyclerAdapter(this)
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view= inflater.inflate(R.layout.fragment_symptoms, container, false)

    val recyclerItems=view.findViewById<RecyclerView>(R.id.recyclerItems)
    val noteRecyclerAdapter=
    SymptomsRecyclerAdapter(activity!!.applicationContext,view.findViewById(R.id.symptomsProcess))
    recyclerItems.layoutManager = noteLayoutManager
    recyclerItems.adapter = noteRecyclerAdapter


//        }
        return view
    }


}
