package com.example.quizapp

object Constants{

    const val User_Name: String = "user_name"
    const val Total_Ques: String = "total_ques"
    const val Correct_Ans: String = "correct_ans"

    fun getQuestion(): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val ques1 = Questions(1,"Which conuntry's flag is this?",
                R.drawable.ic_flag_of_argentina,
                "Argentina", "Cuba",
                "Belgium","Germany",1)

        questionsList.add(ques1)

        val ques2 = Questions(2,"Which conuntry's flag is this?",
            R.drawable.ic_flag_of_australia,
            "NewZealand", "Denmark",
            "Belgium","Australia",4)

        questionsList.add(ques2)

        val ques3 = Questions(3,"Which conuntry's flag is this?",
            R.drawable.ic_flag_of_belgium,
            "Italy", "Belgium",
            "Portugal","Germany",2)

        questionsList.add(ques3)

        val ques4 = Questions(4,"Which conuntry's flag is this?",
            R.drawable.ic_flag_of_germany,
            "Switzerland", "Scotland",
            "Iraq","Germany",4)

        questionsList.add(ques4)

        val ques5 = Questions(5,"Which conuntry's flag is this?",
            R.drawable.ic_flag_of_brazil,
            "Qatar", "Mexico",
            "Brazil","Congo",3)

        questionsList.add(ques5)

        val ques6 = Questions(6,"Which conuntry's flag is this?",
            R.drawable.ic_flag_of_kuwait,
            "UAE", "Oman",
            "Brazil","Kuwait",4)

        questionsList.add(ques6)

        val ques7 = Questions(7,"Which conuntry's flag is this?",
            R.drawable.ic_flag_of_denmark,
            "Argentina", "Denmark",
            "Belgium","Sweden",2)

        questionsList.add(ques7)

        val ques8 = Questions(8,"Which conuntry's flag is this?",
            R.drawable.ic_flag_of_india,
            "Singapore", "China",
            "India","Denmark",3)

        questionsList.add(ques8)

        val ques9 = Questions(9,"Which conuntry's flag is this?",
            R.drawable.ic_flag_of_fiji,
            "Spain", "Fiji",
            "Sweden","Malaysia",2)

        questionsList.add(ques9)

        val ques10 = Questions(10,"Which conuntry's flag is this?",
            R.drawable.ic_flag_of_new_zealand,
            "NewZealand", "Australia",
            "Austria","Switzerland",1)

        questionsList.add(ques10)

        return questionsList

    }
}