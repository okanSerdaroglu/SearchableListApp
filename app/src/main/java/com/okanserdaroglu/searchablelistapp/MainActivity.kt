package com.okanserdaroglu.searchablelistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var animals = ArrayList<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareData()
        var adapter = AnimalListAdapter (animals)
        recyclerViewAnimalList.adapter = adapter


    }

    private fun prepareData () : ArrayList<Animal> {

        var images = arrayOf(R.drawable.ani_cat_one,
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
            R.drawable.bird_parrot_eight)

        var names = arrayOf("Kedi 1", "Kedi 2", "Kedi 3", "Kedi 4", "Kedi 5", "Kedi 6", "Kedi 7",
            "Köpek 1", "Köpek 2", "Köpek 3", "Köpek 4", "Köpek 5",
            "Geyik 1", "Geyik 2", "Geyik 3", "Geyik 4",
            " Papagan 1", " Papagan 2", " Papagan 3", " Papagan 4", " Papagan 5", " Papagan 6", " Papagan 7", " Papagan 8")


        for (i in images.indices){

            var animal = Animal (names[i],images[i])
            animals.add(animal)

        }

        return animals

    }




}
