package com.okanserdaroglu.searchablelistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_animal_list.view.*


class AnimalListAdapter (var animals: ArrayList<Animal>): RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder>(),Filterable {


    var filter : FilterHelper = FilterHelper(animals,this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {

        var row = LayoutInflater.from(parent.context).inflate(R.layout.adapter_animal_list,parent,false)

        return AnimalViewHolder(row)

    }

    override fun getItemCount(): Int {
        return animals.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {

        var animal = animals[position]
        holder.bind(animal,position)

    }

    fun setFilter(searching: ArrayList<Animal>) {

        animals.clear()
        animals.addAll(searching)
        notifyDataSetChanged()

    }

    fun setResults(arrayList: ArrayList<Animal>) { // filter results

        animals = arrayList
        notifyDataSetChanged()

    }

    override fun getFilter(): Filter {

        return filter

    }



    class AnimalViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var rowLayout = itemView as CardView
        var animalName = rowLayout.textViewName!!
        var animalImage = rowLayout.imageViewAnimalImage!!

        fun bind(animal: Animal, position: Int) {

            animalName.text = animal.name
            animalImage.setImageResource(animal.image)

            rowLayout.setOnClickListener {
                Toast.makeText(rowLayout.context,"animal : " + position + " name : " + animal.name,Toast.LENGTH_SHORT).show()
            }

        }



    }

}