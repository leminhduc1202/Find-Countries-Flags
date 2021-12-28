package com.mdapp.countriesflags.NesterRecyclerView

import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mdapp.countriesflags.NesterRecyclerView.adapter.InnerAdapter
import com.mdapp.countriesflags.NesterRecyclerView.adapter.OuterAdapter
import com.mdapp.countriesflags.R
import com.mdapp.countriesflags.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

//        turnOnStrictMode()

        binding.floatingButton.setOnClickListener { view ->
            Snackbar.make(view, " Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

        val subList1 = ArrayList<Int>()
        for (i in 0..10){
            subList1.add(i)
        }

        val list = ArrayList<ArrayList<Int>>()
        for (i in 0..10){
            list.add(subList1)
        }

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = OuterAdapter(object : InnerAdapter.OnItemClickListener{
            override fun onItemClick(view: View, data: Int) {
                Toast.makeText(this@HomeActivity, "Click $data", Toast.LENGTH_SHORT).show()
            }

            override fun onItemLongClick(view: View, data: Int) {
                Toast.makeText(this@HomeActivity, "Long $data", Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView.adapter = adapter
        adapter.updateList(list)
    }

    private fun turnOnStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().penaltyFlashScreen().build()
        )
        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build())
    }
}