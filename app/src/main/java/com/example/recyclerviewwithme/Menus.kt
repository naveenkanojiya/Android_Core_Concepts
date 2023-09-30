package com.example.recyclerviewwithme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import com.example.recyclerviewwithme.databinding.ActivityMenusBinding

class Menus : AppCompatActivity() {

    private val binding: ActivityMenusBinding by lazy {
        ActivityMenusBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.popupMenuButton.setOnClickListener {
            showPopupMenu(it)
        }
    }



    ///PopUp Menu............................................
    fun showPopupMenu(it: View) {
        val popupMenu = PopupMenu(this, it)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.item_zero -> {
                    Toast.makeText(this, "item zero slected", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.item_one -> {
                    startActivity(Intent(this, MainActivity2::class.java))
                    true
                }

                R.id.item_two -> {
                    Toast.makeText(this, "item zero slected", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
            true
        }
    }




    // Option Menu..................
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                Toast.makeText(this, "selected profile", Toast.LENGTH_SHORT).show()

            }

            R.id.setting -> {
                startActivity(Intent(this, MainActivity2::class.java))

            }

            R.id.feedBake -> {
                Toast.makeText(this, "selected feedback", Toast.LENGTH_SHORT).show()

            }

            R.id.logOut -> {
                Toast.makeText(this, "selected logout", Toast.LENGTH_SHORT).show()

            }
        }
        return true

    }
}