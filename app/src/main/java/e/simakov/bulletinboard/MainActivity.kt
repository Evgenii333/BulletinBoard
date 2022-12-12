package e.simakov.bulletinboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import e.simakov.bulletinboard.act.EditAdsAct
import e.simakov.bulletinboard.databinding.ActivityMainBinding
import e.simakov.bulletinboard.dialoghelper.DialogConst
import e.simakov.bulletinboard.dialoghelper.DialogHelper
import e.simakov.bulletinboard.fragments.FragmentAppliances
import e.simakov.bulletinboard.fragments.FragmentMyAds
import e.simakov.bulletinboard.fragments.FragmentPc
import e.simakov.bulletinboard.fragments.FragmentSmartpfone

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var rootElement: ActivityMainBinding
    private val dialogHelper = DialogHelper(this)
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityMainBinding.inflate(layoutInflater)
        val view = rootElement.root
        setContentView(view)
        init()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.id_new_ads) {
            val i = Intent(this, EditAdsAct::class.java)
            startActivity(i)

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun init() {
        setSupportActionBar(rootElement.mainContent.toolbar)
        val toggle = ActionBarDrawerToggle(
                this,
                rootElement.drawerLayout,
                rootElement.mainContent.toolbar,
                R.string.open,
                R.string.close
            )
        rootElement.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        rootElement.navView.setNavigationItemSelectedListener(this)

        rootElement.mainContent.addNewBulletin.setOnClickListener {
            startActivity(Intent(this, EditAdsAct::class.java))
        }
        rootElement.mainContent.btnOpenMenu.setOnClickListener {
            rootElement.drawerLayout.openDrawer(GravityCompat.START);

        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.id_my_ads -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.placeHolder, FragmentMyAds.newInstance()).commit()
            }
            R.id.id_car -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.placeHolder, FragmentCars.newInstance()).commit()
            }
            R.id.id_pc -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.placeHolder, FragmentPc.newInstance()).commit()
            }
            R.id.id_smartpfone -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.placeHolder, FragmentSmartpfone.newInstance()).commit()
            }
            R.id.id_dm -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.placeHolder, FragmentAppliances.newInstance()).commit()
            }
            R.id.id_sign_up -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_UP_STATE)

            }
            R.id.id_sign_in -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_IN_STATE)
            }
            R.id.id_sign_out -> {
                Toast.makeText(this, "Presed id_sign_out", Toast.LENGTH_LONG).show()
            }
        }
        rootElement.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}