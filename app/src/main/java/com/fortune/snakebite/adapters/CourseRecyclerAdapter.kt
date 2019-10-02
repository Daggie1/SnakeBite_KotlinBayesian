package com.fortune.snakebite

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.fortune.snakebite.data_managers.DataManager

class CourseRecyclerAdapter(val context: Context) : RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder>()
{
    private val layoutInflater = LayoutInflater.from(context)
    private val disease = DataManager.disease.values.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_disease, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return DataManager.disease.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val disease = disease[position]
        holder.textDisease.text = disease?.title
        holder.currentPosition = position

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textDisease: TextView = itemView.findViewById<TextView>(R.id.textCourse)
        var currentPosition = 0;

        init {
            itemView.setOnClickListener {v ->
                var disease=DataManager.disease[disease[currentPosition].diseaseId]
                val bundle= bundleOf("disease" to disease)
                Navigation.findNavController(v)
                    .navigate(R.id.action_diseaseFragment_to_resultsFragment,bundle)
            }
        }
    }
}