package com.example.ejemplohandlers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplohandlers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnIniciar.setOnClickListener {
            pasarPantalla()
        }

    }
   private fun pasarPantalla(){
        val mensaje="Estudiante"
       val numero =10
       //configurar un intent para generar la intencion de querer pasar
       //de una pantalla A a una Pantalla B enviamos datos
       //primitivos.....
       //Pasar datos se usa archivo tempotral llamado Extras..
       //Extras:formato de cada registro es:llave -valor
       val intent=Intent(this, Bienvenida ::class.java)
           intent.apply {
               putExtra("texto",mensaje)
               putExtra("valor",numero)
           }

       startActivity(intent)
    }
}