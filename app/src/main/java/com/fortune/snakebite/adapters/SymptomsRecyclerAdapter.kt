package com.jwhh.notekeeper

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.fortune.snakebite.R
import com.fortune.snakebite.data_managers.DataManager

import com.fortune.snakebite.inference_engine.Classifier
import com.google.android.material.button.MaterialButton

class SymptomsRecyclerAdapter(val context: Context, val processBtn:MaterialButton) : RecyclerView.Adapter<SymptomsRecyclerAdapter.ViewHolder>()
{
    private var symptomsSelected= arrayListOf<String>()

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater. inflate(R.layout.item_systoms, parent, false)
        return ViewHolder(itemView)

    }

    override fun getItemCount(): Int {

        return DataManager.getAllSymptoms().size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val symptom = DataManager.getAllSymptoms()[position]
        holder.textSymptomTitle.text = symptom

       // holder.textSymptomDescription.text = symptom.text
        holder.currentPosition = position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textSymptomTitle: TextView = itemView.findViewById<TextView>(R.id.textCourse)
        val symptomCheckBox: CheckBox = itemView.findViewById<CheckBox>(R.id.selectCheckBox)
        val symptomCard: CardView = itemView.findViewById<CardView>(R.id.symptomsCard)

        var currentPosition = 0;

        init {
            itemView.setOnClickListener {
//                val intent = Intent(context, NoteActivity::class.java)
//                intent.putExtra(NOTE_POSITION, currentPosition)
//                context.startActivity(intent)
                if(!symptomCheckBox.isVisible){
                    symptomCheckBox.visibility=View.VISIBLE
                }

        }
            symptomCheckBox.setOnCheckedChangeListener{buttonView,isChecked->
                addorRemoveSymptom(itemView)
            }
    }
        fun process( v:View){
            processBtn.setOnClickListener {
                    val classifier = Classifier()
              //  Toast.makeText(context,classifier.classifyText(symptomsSelected.toString())!!.title,Toast.LENGTH_LONG).show()import com.fortune.snakebite.data_managers.Disease
var disease=classifier.classifyText(symptomsSelected.toString())
                val bundle= bundleOf("disease" to disease)
                                findNavController(v).navigate(R.id.action_symptomsFragment_to_resultsFragment,bundle)

            }
        }
        private fun addorRemoveSymptom(v:View){
            if(symptomCheckBox.isChecked){
               symptomsSelected.add(textSymptomTitle.text.toString())
//                Toast.makeText(context,symptomsSelected.toString(),Toast.LENGTH_LONG).show()

            }else{
                symptomsSelected.remove(textSymptomTitle.text.toString())
//                Toast.makeText(context,symptomsSelected.toString(),Toast.LENGTH_LONG).show()
            }
            if(symptomsSelected.size<2){
                processBtn.visibility=View.GONE
            }
            else{
                process(v)
                processBtn.visibility=View.VISIBLE
            }
        }
}
}