package it.bz.noi.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import it.bz.noi.community.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            window.navigationBarColor =
                resources.getColor(R.color.black, theme)
        } else {
            window.navigationBarColor = resources.getColor(R.color.black)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_today,
                R.id.navigation_orientate,
                R.id.navigation_meet,
                R.id.navigation_eat,
                R.id.navigation_more
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.navigation_more -> {
                    supportActionBar?.hide()
                }
                else -> {
                    supportActionBar?.show()
                }
            }
        }
    }
}