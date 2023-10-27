package com.gezioteam.gezio;


import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.gezioteam.gezio.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.nav_open,R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener ( this)
        binding.bottomNavigation.background=null
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.bottom_home -> openFragment(HomeFragment())
                R.id.bottom_schedule -> openFragment(ScheduleFragment())
                R.id.bottom_favorite -> openFragment(FavoriteFragment())

            }
            true
        }

        fragmentManager=supportFragmentManager
        openFragment(HomeFragment())

        binding.fab.setOnClickListener{
            Toast.makeText(this,"Select Location",Toast.LENGTH_SHORT).show()
            openFragment(LocationFragment())
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home ->openFragment(HomeFragment())
            R.id.nav_location ->openFragment(LocationFragment())
            R.id.nav_schedule ->openFragment(ScheduleFragment())
            R.id.nav_favorite ->openFragment(FavoriteFragment())

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.getOnBackPressedDispatcher().onBackPressed()
        }
    }

    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()

    }

}
