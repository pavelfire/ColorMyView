package com.vk.directop.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

//https://developer.android.com/topic/libraries/view-binding
class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListeners()

        //this code prints cake in console
        val age = 38
        val layers = 5
        printCakeCandles(age)
        printCakeTop(age)
        printCakeBottom(age, layers)
    }

    private fun setListeners() {
        val clickableViews: List<View> =
                listOf(box_one_text, box_two_text, box_three_text, box_four_text, box_five_text,
                        constraint_layout, red_button, yellow_button, green_button)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            //Boxes using Colo class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            //Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            //Boxes using custom colors for background
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_three_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_three_text.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }


    fun printCakeCandles(age: Int) {
        print(" ")
        repeat(age) {
            print(",")
        }
        println("")
        print(" ")
        repeat(age) {
            print("|")
        }
        println()
    }

    fun printCakeTop(age: Int) {
        repeat(age + 2) {
            print("=")
        }
        println()
    }


    fun printCakeBottom(age: Int, layers: Int) {
        repeat(layers) {
            repeat(age + 2) {
                print("@")
            }
            println()
        }

    }
}