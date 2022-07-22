package com.faith.androidmenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.buttonPopUpMenu)

        button.setOnLongClickListener {
            val popupMenu = PopupMenu(this, button)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

            //listener
            popupMenu.setOnMenuItemClickListener { item ->
                if (item.itemId == R.id.menu_item_delete) {
                   Toast.makeText(this,"DELETING",Toast.LENGTH_SHORT).show()
                }else if (item.itemId==R.id.menu_item_edit){
                    Toast.makeText(this,"EDITING",Toast.LENGTH_SHORT).show()
                }

                true
            }

            popupMenu.show()
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_share -> Toast.makeText(this, "Sharing", Toast.LENGTH_SHORT).show()
            R.id.menu_item_call -> Toast.makeText(this, "Calling", Toast.LENGTH_SHORT).show()
            R.id.menu_item_sms -> Toast.makeText(this, "Sending Message", Toast.LENGTH_SHORT).show()
            R.id.menu_item_help -> Toast.makeText(this, "Get Help", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}