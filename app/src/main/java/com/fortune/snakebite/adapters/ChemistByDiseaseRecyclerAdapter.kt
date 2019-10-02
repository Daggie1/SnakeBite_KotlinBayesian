package com.jwhh.notekeeper

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView

import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.fortune.snakebite.R
import com.fortune.snakebite.data_managers.DataManager

import com.fortune.snakebite.inference_engine.Classifier
import com.google.android.material.button.MaterialButton

import kotlinx.android.synthetic.main.item_systoms.view.*

class ChemistByDiseaseRecyclerAdapter(val context: Context, val diseaseId:String) : RecyclerView.Adapter<ChemistByDiseaseRecyclerAdapter.ViewHolder>()
{
    private var symptomsSelected= arrayListOf<String>()

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater. inflate(R.layout.item_systoms, parent, false)
        return ViewHolder(itemView)

    }

    override fun getItemCount(): Int {

        return DataManager.findChemistSymptomById(diseaseId = diseaseId).size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val symptom = DataManager.findChemistSymptomById(diseaseId)[position]
        holder.textSymptomTitle.text = symptom
holder.sympomImage.setImageResource(R.drawable.ic_location_city_black_24dp)
       // holder.textSymptomDescription.text = symptom.text
        holder.currentPosition = position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textSymptomTitle: TextView = itemView.findViewById<TextView>(R.id.textCourse)
        val sympomImage: ImageView = itemView.findViewById<ImageView>(R.id.symptomImage)

        var currentPosition = 0;

        init {
            itemView.setOnClickListener {


        }

            }
    }

        }

