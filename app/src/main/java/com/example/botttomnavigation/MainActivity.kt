package com.example.botttomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.botttomnavigation.Fragment.HomeFragment
import com.example.botttomnavigation.Fragment.ProfileFragment
import com.example.botttomnavigation.Fragment.SearchFragment
import com.example.botttomnavigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(HomeFragment())

        binding.bottomNavView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when(item.itemId){

                    R.id.home->{

                        loadFragment(HomeFragment())
                    }
                    R.id.search->{

                        loadFragment(SearchFragment())
                    }
                    R.id.profile->{

                        loadFragment(ProfileFragment())
                    }
                }

                return true
            }

        })
    }

    fun loadFragment(fragment : Fragment){

        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()

    }
}