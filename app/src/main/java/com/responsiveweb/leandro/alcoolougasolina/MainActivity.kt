package com.responsiveweb.leandro.alcoolougasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnCalcular(view: View){

        // Recupera valores digitados
        //val precoAlcool = findViewById<EditText>(R.id.edit_texto_alcool)
        //val precoGasolina = findViewById<EditText>(R.id.edit_texto_gasolina)
        //val textoRecuperado = precoAlcool.text.toString()

        val precoAlcool = edit_texto_alcool.text.toString()
        val precoGasolina = edit_texto_gasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)

        if(validaCampos == true){
            this.calcularMelhorPreco(precoAlcool, precoGasolina)
        }else{
            texto_resultado.setText("Digite os dois valores")
        }

        
    }

    fun validarCampos( precoAlcool: String, precoGasolina: String ) : Boolean{

        var camposValidados: Boolean = true

        if(precoAlcool == null || precoAlcool.equals("")){

            camposValidados = false

        }else if(precoGasolina == null || precoGasolina.equals("")){

            camposValidados = false
        }

        return camposValidados
    }

    fun calcularMelhorPreco( precoAlcool: String, precoGasolina: String){

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina

        if(resultadoPreco >= 0.7){
            texto_resultado.setText("Melhor utilizar Gasolina!")
        }else{
            texto_resultado.setText("Melhor utilizar Alcool!")
        }

    }
}
