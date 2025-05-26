package vcmsa.ci.quiz_dynasty

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

       val score = intent.getIntExtra("score",0)
        val totalQuestions=intent.getIntExtra("totalQuestions", 0)
        val questions = intent.getStringExtra("questions")
        val answers=intent.getStringArrayExtra("answers")


        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtFeedback= findViewById<TextView>(R.id.txtFeedback)
        val btnReview= findViewById<Button>(R.id.btnReview)
        val btnExit= findViewById<Button>(R.id.btnExit)

        txtScore.text= "You scored $score/$totalQuestions"

        if (score>=3){
            txtFeedback.text="Good Job!"
        } else {
            txtFeedback.text="Continue practising!"
        }
        btnReview.setOnClickListener {
            val intent= Intent(this,MainActivity2::class.java)
            intent.putExtra("questions", questions)
            intent.putExtra("answers", answers)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            finishAffinity()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}