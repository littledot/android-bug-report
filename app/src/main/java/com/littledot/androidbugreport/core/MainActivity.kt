package com.littledot.androidbugreport.core

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.littledot.androidbugreport.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportFragmentManager.beginTransaction()
            .replace(R.id.root, MainFragment(), null)
            .commit()
    }
}

class MainFragment : Fragment(R.layout.main_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val items = mapOf(
            "AutoDispose427" to AutoDispose427(),
            "Coil206" to Coil206(),
            "Coil387" to Coil387(),
            "SqlDelight1818" to SqlDelight1818(),
            "SqlDelight1920" to SqlDelight1820(),
            "ZoomLayout209" to ZoomLayout209(),
        )

        list.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items.keys.toList())
        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val key = items.keys.toList()[position]
            items[key]?.let {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.root, it)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

}
