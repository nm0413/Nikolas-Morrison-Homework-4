package com.msu.morrison.geoquiz4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.msu.morrison.geoquiz4.databinding.ActivityMainBinding



private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: QuizViewModel by viewModels()

    private var answerChosen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")



        binding.trueButton.setOnClickListener{
            if (!answerChosen) {
                checkAnswer(true)
                answerChosen = true
            }
        }


        binding.falseButton.setOnClickListener{
            if (!answerChosen) {
                checkAnswer(false)
                answerChosen = true
            }
        }

        binding.nextButton.setOnClickListener{
            quizViewModel.moveToNext()
            updateQuestion()
        }

        updateQuestion()
    }



    private fun disableButtons(){
        binding.trueButton.isEnabled = false
        binding.falseButton.isEnabled = false
    }

    private fun enableButtons(){
        binding.trueButton.isEnabled = true
        binding.falseButton.isEnabled = true
    }

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextview.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = quizViewModel.currentQuestionAnswer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

}