package com.example.ejemplohandlers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.ejemplohandlers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Inicializar el handler... como nuestra interaccion
        //va a ser entre solo un hilo y el hilo de la interfaz de usuario
        //el looper que vamos a configurar se llama mainLooper
        myHandler=Handler(mainLooper)
        binding.btnIniciar.setOnClickListener {
            pasarPantalla()
            iniciarProcesoParalelo()
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
    private fun iniciarProcesoParalelo(){
        Thread{
            try {
                for(i in 0..100){
                    Thread.sleep(500)
                    myHandler.post{
                        //va a comunicarse con la UI Thread
                        binding.apply{
                            txtPorcentaje.text="$i%"
                            PB.progress=i
                        }
                    }
                }
            }catch (e:InterruptedException){
                e.printStackTrace()
            }

        }.start()

    }
}