package vcmsa.ci.quiz_dynasty

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

       val questions = arrayOf(
          "The TRC was established to prosecute apartheid era crimes",
          "Desmond Tutu was the chairpeson of the TRC",
          "The TRC had the power to grant amnesty to all aplicants",
          "The TRC only heard testimonies from victims of apartheid era crimes",
          "The TRC was established in 1995"
      )
        val answers = arrayOf(
            "False",
            "True",
            "False",
            "False",
            "True",
        )
        val userAnswers= mutableListOf<String>()
        var currentIndex=0
       var score=0

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

val txtQuestions=findViewById<TextView>(R.id.txtQuestions)
val btnTrue=findViewById<Button>(R.id.btnTrue)
val btnFalse=findViewById<Button>(R.id.btnFalse)
val btnNext =findViewById<Button>(R.id.btnNext)
val btnScore=findViewById<Button>(R.id.btnScore)


        fun updateQuestion() {
            if (currentIndex < questions.size) {
                txtQuestions.text = questions[currentIndex]
            }
        }
txtQuestions.text="Q${currentIndex +1}: ${questions[currentIndex]}"

        fun checkAnswer(userAnswer:String){
            if (userAnswer == answers[currentIndex]){
                Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show()
                score++
            }else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
            currentIndex++
            updateQuestion()
        }
btnTrue.setOnClickListener {
    checkAnswer("True")
}
        btnFalse.setOnClickListener {
            checkAnswer("False")
        }
btnScore.setOnClickListener {
    val intent= Intent(this,MainActivity3::class.java)
    startActivity(intent)
    intent.putExtra("score", score)
    intent.putExtra("totalQuestions", questions.size)
    intent.putExtra("questions", questions)
    intent.putExtra("answers", answers)
    intent.putExtra("userAnswer", userAnswers.toTypedArray())
    startActivity(intent)

}
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}