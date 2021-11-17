package com.eurofins.bottomappbarwithfab

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eurofins.bottomappbarwithfab.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomAppBar = binding.bottomAppBar
        val navigationView = binding.bottomNavView
        val floatingActionbar = binding.floatingActionButton
        val bottomSheetBehavior = BottomSheetBehavior.from(navigationView)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        bottomAppBar.setNavigationOnClickListener {
            // Here the drawer menu is showed using bottomsheet instead od drawer layout
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            floatingActionbar.visibility = View.GONE

        }

        bottomSheetBehavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                Log.d("Wagle", "$newState is the state os navigation bar")
                if(newState == BottomSheetBehavior.STATE_HIDDEN){
                    floatingActionbar.visibility = View.VISIBLE
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("agle", "$slideOffset is the state os navigation bar")
            }

        })

        bottomAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.add_photo->{
                    Toast.makeText(this, "Handle Button Press", Toast.LENGTH_LONG).show()
                    true
                }
                else -> false
            }
        }

        val paintBrush = binding.paintBrush

        paintBrush.setOnClickListener {
            Toast.makeText(this, "Handle Button Press", Toast.LENGTH_LONG).show()
        }
    }



}