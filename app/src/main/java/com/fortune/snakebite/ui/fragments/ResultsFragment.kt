package com.fortune.snakebite.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fortune.snakebite.R
import com.fortune.snakebite.data_managers.Disease
import com.google.android.material.tabs.TabLayout
import com.jwhh.notekeeper.ChemistByDiseaseRecyclerAdapter
import com.jwhh.notekeeper.RecommedationByDiseaseRecyclerAdapter
import com.jwhh.notekeeper.SymptomsByDiseaseRecyclerAdapter

/**
 * A simple [Fragment] subclass.
 */
class ResultsFragment : Fragment(),TabLayout.OnTabSelectedListener {
    val dynamicLayoutManager by lazy {
        LinearLayoutManager(activity)
    }
    val symptomRecyclerAdapter by lazy {
        SymptomsByDiseaseRecyclerAdapter(activity!!.applicationContext,diseaseId = disease.diseaseId)
    }
    val treatmentRecyclerAdapter by lazy {
       RecommedationByDiseaseRecyclerAdapter(activity!!.applicationContext,diseaseId = disease.diseaseId)
    }
    val chemistRecyclerAdapter by lazy {
        ChemistByDiseaseRecyclerAdapter(activity!!.applicationContext,diseaseId = disease.diseaseId)
    }
    lateinit var recycler:RecyclerView
    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
      var t=  tab!!.position

        when(t){
            0->recycler.adapter=symptomRecyclerAdapter
            1->recycler.adapter=treatmentRecyclerAdapter
            2->recycler.adapter=chemistRecyclerAdapter
        }
       // Toast.makeText(activity,t.toString(),Toast.LENGTH_SHORT).show()





    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }

    lateinit var disease:Disease
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view:View= inflater.inflate(R.layout.fragment_results, container, false)
        view.findViewById<TextView>(R.id.snakecausingtxt).text=disease.causingSnake
        view.findViewById<TextView>(R.id.diseaseTxtView).text=disease.title
        view.findViewById<TabLayout>(R.id.tabs).addOnTabSelectedListener(this)
        recycler=view.findViewById(R.id.daynamicRecycler)
        recycler.layoutManager = dynamicLayoutManager
        recycler.adapter = symptomRecyclerAdapter
        return  view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     disease=   arguments!!.getParcelable<Disease>("disease")
    }
}
