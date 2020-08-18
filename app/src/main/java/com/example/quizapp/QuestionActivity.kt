package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private  var mCurrentPos: Int = 1
    private  var mQuestionsList : ArrayList<Questions>? = null
    private var mSelectedOptionPos: Int = 0
    private var mCorrectAns: Int = 0
    private var mUsername: String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        mUsername = intent.getStringExtra(Constants.User_Name)
        mQuestionsList = Constants.getQuestion()
        setQuestion()

        tv_option1.setOnClickListener(this)
        tv_option2.setOnClickListener(this)
        tv_option3.setOnClickListener(this)
        tv_option4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){

        //mCurrentPos = 1
        val question = mQuestionsList?.get(mCurrentPos - 1)
        defaultOptionView()

        if(mCurrentPos == mQuestionsList!!.size)
        {
            btn_submit.text = "FINISH"
        }
        else
        {
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPos
        tv_progess.text = "$mCurrentPos" + "/" + progressBar.max
        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option1.text = question.option1
        tv_option2.text = question.option2
        tv_option3.text = question.option3
        tv_option4.text = question.option4
    }
    private fun defaultOptionView(){

        val options = ArrayList<TextView>()
        options.add(0, tv_option1)
        options.add(1, tv_option2)
        options.add(2, tv_option3)
        options.add(3, tv_option4)

        for (option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_bg
            )
        }
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.tv_option1 ->{
                selectedOptionView(tv_option1, 1)
            }
            R.id.tv_option2 ->{
                selectedOptionView(tv_option2, 2)
            }
            R.id.tv_option3 ->{
                selectedOptionView(tv_option3, 3)
            }
            R.id.tv_option4 ->{
                selectedOptionView(tv_option4, 4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPos == 0){
                    mCurrentPos++

                    when{
                        mCurrentPos <= mQuestionsList!!.size->{
                            setQuestion()
                        }
                        else->{
                            Toast.makeText(this, "You have successfully completed the quiz!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.User_Name, mUsername)
                            intent.putExtra(Constants.Correct_Ans, mCorrectAns)
                            intent.putExtra(Constants.Total_Ques, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestionsList?.get(mCurrentPos -1)
                    if(question!!.correctAns != mSelectedOptionPos){
                        answerView(mSelectedOptionPos, R.drawable.wrong_option_bg)
                    }
                    else{
                        mCorrectAns++
                    }
                    answerView(question.correctAns, R.drawable.correct_option_bg)
                    if(mCurrentPos == mQuestionsList!!.size){
                        btn_submit.text = "FINISH"
                    }
                    else{
                        btn_submit.text = "Next Question"
                    }
                    mSelectedOptionPos = 0
                }
            }
        }
    }
    private  fun answerView(answer:Int, drawableView:Int)
    {
        when(answer)
        {
            1->{
                tv_option1.background = ContextCompat.getDrawable(
                    this,
                    drawableView)
            }
            2->{
                tv_option2.background = ContextCompat.getDrawable(
                    this,drawableView)
            }
            3->{
                tv_option3.background = ContextCompat.getDrawable(
                    this,
                    drawableView)
            }
            4->{
                tv_option4.background = ContextCompat.getDrawable(
                    this,
                    drawableView)
            }
        }
    }

    private  fun selectedOptionView(tv: TextView, selectedOptionNum: Int)
    {
        defaultOptionView()
        mSelectedOptionPos = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
    }
}
