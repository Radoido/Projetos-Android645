package com.main.contador_magic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.main.contador_magic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.main)

        val menu = binding.options
        val reset = menu.findViewById<View>(R.id.btnReset)

        reset.setOnClickListener{
            binding.textP1.text = "20"
            binding.textP2.text = "20"
        }

        var isMenuOpen = false


        binding.btnMenu.setOnClickListener{
            isMenuOpen = !isMenuOpen
            val layoutParams = binding.btnMenu.layoutParams as RelativeLayout.LayoutParams
            if(isMenuOpen){
                layoutParams.addRule(RelativeLayout.ABOVE, R.id.options)
                binding.btnMenu.text = "-"
            }
            else
                { layoutParams.removeRule(RelativeLayout.ABOVE) }
            binding.options.visibility = if(binding.options.visibility == View.VISIBLE)
                                            { View.GONE }
                                        else
                                            {
                                                View.VISIBLE
                                            }
            binding.btnMenu.layoutParams = layoutParams
        }


        binding.btnSomaP1.setOnClickListener{
            val contador = binding.textP1.text.toString().toInt()
            binding.textP1.text = (contador + 1).toString()

        }

        binding.btnSubtraiP1.setOnClickListener{
            val contador = binding.textP1.text.toString().toInt()
            binding.textP1.text = (contador - 1).toString()
        }

        binding.btnSomaP2.setOnClickListener{
            val contador = binding.textP2.text.toString().toInt()
            binding.textP2.text = (contador + 1).toString()

        }

        binding.btnSubtraiP2.setOnClickListener{
            val contador = binding.textP2.text.toString().toInt()
            binding.textP2.text = (contador - 1).toString()

        }


    }
}