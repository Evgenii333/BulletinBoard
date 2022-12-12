package e.simakov.bulletinboard.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import e.simakov.bulletinboard.R
import e.simakov.bulletinboard.utils.CityHelper

class DialogSpinnerHelper {
    fun showSpinnerDialog(context:Context, list:ArrayList<String>, tvSelection: TextView){
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()

        val rootView = LayoutInflater.from(context).inflate(R.layout.spinner_layout, null)
        val adapter = RcViewDialogSpinnerAdapter(tvSelection, dialog)
        val rcView = rootView.findViewById<RecyclerView>(R.id.rcSpView)

        val sv = rootView.findViewById<SearchView>(R.id.svSpinner)

        rcView.layoutManager = LinearLayoutManager(context)
        rcView.adapter = adapter
        dialog.setView(rootView)
        adapter.updateAdapter(list)
        setSearchView(adapter, list, sv)
        dialog.show()

    }

    private fun setSearchView(adapter: RcViewDialogSpinnerAdapter, list: ArrayList<String>, sv: SearchView?) {
        sv?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                val tempList = CityHelper.filteredListData(list, p0)
                adapter.updateAdapter(tempList)
                return true
            }
        })

    }


}

