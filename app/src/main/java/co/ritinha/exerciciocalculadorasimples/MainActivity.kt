package co.ritinha.exerciciocalculadorasimples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    private lateinit var  editNumberA: EditText
    private lateinit var  editNumberB: EditText
    private lateinit var  btnCalculate: Button
    private lateinit var  textResult: TextView
    private lateinit var  textSoma: TextView
    private lateinit var  textSub: TextView
    private lateinit var  textMult: TextView
    private lateinit var  textDiv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // função importa objetos
        import()

        // onclick botão
        btnCalculate.setOnClickListener {
            val numberA = editNumberA.text.toString()
            val numberB = editNumberB.text.toString()
            generateCalculate(numberA, numberB, textSoma, textSub, textMult, textDiv)
        }

    }

    private fun generateCalculate(textA: String, textB: String, textSoma: TextView, textSub: TextView,
                                  textMult: TextView, textDiv: TextView){
        // falha
        if (textA.isEmpty() || textB.isEmpty()){
            Toast.makeText(this, "Informe um valor", Toast.LENGTH_SHORT).show()
            return
        }

        // sucesso
        textResult.text = "Resultado: "


        val numberA = textA.toInt()
        val numberB = textB.toInt()

        // soma
        soma(numberA, numberB, textSoma)
        // subtracao
        sub(numberA, numberB, textSub)
        // multiplicacao
        mult(numberA, numberB, textMult)
        // divisao
        div(numberA, numberB, textDiv)

    }

    // funções operações

    fun soma(numberA: Int, numberB: Int, textSoma: TextView){
        val soma = numberA + numberB
        textSoma.text = "Soma: ${soma.toString()}"
    }

    fun sub(numberA: Int, numberB: Int, textSub: TextView){
        val sub = numberA - numberB
        textSub.text = "subtação: ${sub.toString()}"
    }

    fun mult(numberA: Int, numberB: Int, textDiv: TextView){
        val mult = numberA * numberB
        textMult.text = "Multiplicação: ${mult.toString()}"
    }

    fun div(numberA: Int, numberB: Int, textDiv: TextView){
        if (numberB == 0){
            textDiv.text = "Divisão por 0 não é permitida"
        } else {
            val div = numberA / numberB
            textDiv.text = "Divisão: ${div.toString()}"
        }
    }

    // função de importar

    fun import(){
        // objetos
        editNumberA = findViewById(R.id.edit_numberA)
        editNumberB = findViewById(R.id.edit_numberB)
        btnCalculate = findViewById(R.id.btn_calculate)
        textResult = findViewById(R.id.text_result)
        textSoma = findViewById(R.id.text_soma)
        textSub = findViewById(R.id.text_sub)
        textMult = findViewById(R.id.text_mult)
        textDiv  = findViewById(R.id.text_div)
    }
}