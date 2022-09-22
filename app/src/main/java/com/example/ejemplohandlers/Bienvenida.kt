package com.example.ejemplohandlers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplohandlers.databinding.ActivityBienvenidaBinding

class Bienvenida : AppCompatActivity() {
    //en el binding en el private lateinit se debe referencia a la vista que se este haciendo
    private lateinit var binding: ActivityBienvenidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
       //Si esta Pantalla es lanzada de una intencion
        //en una variable llamada intent ya se encontrara toda
        //la configuracion enviada y por tanto las variables en extras
        intent.getStringExtra("texto")
        intent.getIntExtra("valor",0)
        val respuesta="""
            el texto es:${intent.getStringExtra("texto")}
            su valor es:${intent.getIntExtra("valor",0)}
        """.trimIndent()
        binding.txtResultado.text=respuesta

    }

}