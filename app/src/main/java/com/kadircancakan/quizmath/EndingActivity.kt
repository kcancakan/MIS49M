package com.kadircancakan.quizmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kadircancakan.quizmath.databinding.ActivityEndingBinding

class EndingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEndingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val correctAnswers = intent.getIntExtra(QuestionGenerator.countCorrect,0)
        binding.scoreText.text = "Your Score: $correctAnswers / 12"

        val remainingTime = intent.getLongExtra("remainingTime",0)
        val spentTime = 60 - remainingTime
        binding.remainingText.text = "Remaining Time : $remainingTime seconds"
        binding.spentText.text = "Time Spent : $spentTime seconds"

        if(correctAnswers > 6){
            binding.congratsText.text = "CONGRATULATIONS!"
        }else{
            binding.congratsText.text = "YOU CAN DO BETTER!"
        }

        binding.tryAgainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}