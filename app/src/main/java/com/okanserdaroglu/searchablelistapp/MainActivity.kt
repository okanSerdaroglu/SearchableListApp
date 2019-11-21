package com.okanserdaroglu.searchablelistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener,
    androidx.appcompat.widget.SearchView.OnQueryTextListener {

    var animals = ArrayList<Animal>()
    lateinit var adapter: AnimalListAdapter // lateinit means this variable is going to initialize later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareData()
        adapter = AnimalListAdapter(animals)
        recyclerViewAnimalList.adapter = adapter
        searchViewAnimals.setOnQueryTextListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.filter_menu, menu)
        var searchBar = menu?.findItem(R.id.app_bar_search)

        var searchView = searchBar?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    private fun prepareData(): ArrayList<Animal> {

        val images = arrayOf(
            R.drawable.ani_cat_one,
            R.drawable.ani_cat_two,
            R.drawable.ani_cat_three,
            R.drawable.ani_cat_four,
            R.drawable.ani_cat_five,
            R.drawable.ani_cat_six,
            R.drawable.ani_cat_seven,

            R.drawable.ani_dog_one,
            R.drawable.ani_dog_two,
            R.drawable.ani_dog_three,
            R.drawable.ani_dog_four,
            R.drawable.ani_dog_five,

            R.drawable.ani_deer_one,
            R.drawable.ani_deer_two,
            R.drawable.ani_deer_three,
            R.drawable.ani_deer_four,

            R.drawable.bird_parrot_one,
            R.drawable.bird_parrot_two,
            R.drawable.bird_parrot_three,
            R.drawable.bird_parrot_four,
            R.drawable.bird_parrot_five,
            R.drawable.bird_parrot_six,
            R.drawable.bird_parrot_seven,
            R.drawable.bird_parrot_eight
        )

        val names = arrayOf(
            "Kedi 1",
            "Kedi 2",
            "Kedi 3",
            "Kedi 4",
            "Kedi 5",
            "Kedi 6",
            "Kedi 7",
            "Köpek 1",
            "Köpek 2",
            "Köpek 3",
            "Köpek 4",
            "Köpek 5",
            "Geyik 1",
            "Geyik 2",
            "Geyik 3",
            "Geyik 4",
            " Papagan 1",
            " Papagan 2",
            " Papagan 3",
            " Papagan 4",
            " Papagan 5",
            " Papagan 6",
            " Papagan 7",
            " Papagan 8"
        )


        for (i in images.indices) {

            val animal = Animal(names[i], images[i])
            animals.add(animal)

        }

        return animals

    }


    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {

        /*var inputString = p0?.toLowerCase()
        var searchingList = ArrayList<Animal>()

        for (searchingAnimal in animals) {

            var name = searchingAnimal.name.toLowerCase()

            if (name.contains(inputString.toString())) {
                searchingList.add(searchingAnimal)
            }

        }

        adapter.setFilter(searchingList)
        return true*/

        adapter.getFilter().filter(p0)

        return true  //

    }


}
