package e.simakov.bulletinboard.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import e.simakov.bulletinboard.R
import e.simakov.bulletinboard.databinding.ActivityEditAdsBinding
import e.simakov.bulletinboard.dialogs.DialogSpinnerHelper
import e.simakov.bulletinboard.utils.CityHelper

class EditAdsAct : AppCompatActivity() {
    lateinit var rootElement:ActivityEditAdsBinding
    private val dialog = DialogSpinnerHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityEditAdsBinding.inflate(layoutInflater)
        setContentView(rootElement.root)
        init()
    }

    private fun init(){

    }

    //OnClicks
    fun onClickSelectCountry(view:View){
        val listCountry = CityHelper.getAllCountries(this)
        dialog.showSpinnerDialog(this, listCountry, rootElement.tvCountry)
        if(rootElement.tvCities.text.toString() != getString(R.string.select_city)){
            rootElement.tvCities.text = getString(R.string.select_city)
        }

    }

    fun onClickSelectCity(view:View){
        val selectedCountry = rootElement.tvCountry.text.toString()
        if(selectedCountry != getString(R.string.select_country)) {
            val listCities = CityHelper.getAllCities(selectedCountry, this)
            dialog.showSpinnerDialog(this, listCities, rootElement.tvCities)
        } else {
            Toast.makeText(this, "No country selected", Toast.LENGTH_LONG).show()
        }

    }

}