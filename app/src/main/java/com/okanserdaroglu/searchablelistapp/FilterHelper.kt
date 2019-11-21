package com.okanserdaroglu.searchablelistapp

import android.widget.Filter

class FilterHelper(allAnimals: ArrayList<Animal>, adapter: AnimalListAdapter) : Filter() {

    var allAnimals = allAnimals
    var adapter = adapter

    override fun performFiltering(constarint: CharSequence?): FilterResults {

        var result = FilterResults()

        if (constarint != null && constarint.isNotEmpty()) {

            var searchingChar = constarint.toString().toLowerCase()

            var resultList = ArrayList<Animal>()

            for (animal in allAnimals) {

                var name = animal.name.toLowerCase()

                if (name.contains(searchingChar)) {

                    resultList.add(animal)

                }

            }

            result.values = resultList
            result.count = resultList.size

        } else {

            result.values = allAnimals
            result.count = allAnimals.size

        }

        return result
    }

    override fun publishResults(p0: CharSequence?, results: FilterResults?) {

        adapter.setResults (results?.values as ArrayList<Animal>)


    }

}