package com.example.quizapp

object CreateQuestionList {

    const val USER_NAME :String ="User_name"
    const val TOTAL_QUESTION :String ="Total_Question"
    const val CORRECT_ANSWER :String ="Correct_Answer"

    fun getQuestionList (): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val q1 = Question(1,
        "Which country dose have flag belong to ?",
        R.drawable.ic_flag,
        "Australia","USA",
        "India","Turkey",
        3)
        questionList.add(q1)

        val q2 = Question(2,
        "Name of The Following Politician ?",
        R.drawable.ic_politician,
        "Narendra Modi","Rahul Gandhi",
        "Lalu Prasad Yadav","Sachin Pilot",
        1)
        questionList.add(q2)

        val q3 = Question(3,
            "Following minister belongs to which ministry of India ?",
            R.drawable.ic_minister,
            "Railway","Sports",
            "Defence","Home",
            4)
        questionList.add(q3)

        val q4 = Question(4,
            "He is the CM of ________ ?",
            R.drawable.ic_cm,
            "Gujarat","Maharashtara",
            "Utter Pradesh","Bihar",
            3)
        questionList.add(q4)

        val q5 = Question(5,
            "Name of following Sportsman ?",
            R.drawable.ic_sportman,
            "Hardik Pandya","MS Dhoni",
            "Virat Kohli","Rohit Shrma",
            1)
        questionList.add(q5)

        val q6 = Question(6,
            "Name of Following Male Bollywood Celebrity?",
            R.drawable.ic_hero,
            "Ranbir Kapoor","Aushman Khurana",
            "Manoj Bajpyee","Pankaj Tripathi",
            2)
        questionList.add(q6)

        val q7 = Question(7,
            "Name of Following Female Bollywood Celebrity? ?",
            R.drawable.ic_heroine,
            "Shrddha Kapoor","Kiara Advani",
            "Dish Patani","Jacqueline",
            4)
        questionList.add(q7)

        val q8 = Question(8,
            "Name of Following  Hollywood Celebrity? ?",
            R.drawable.ic_hollywood,
            "Jason statham","Tony stark",
            "Tom Cruz","Paul walker",
            3)
        questionList.add(q8)

        val q9 = Question(9,
            "Name of Following Sport?",
            R.drawable.ic_sport,
            "Ice Hockey","Hockey",
            "Football","Volleyball",
            2)
        questionList.add(q9)

        val q10 = Question(10,
            "Name of Following Singer?",
            R.drawable.ic_singer,
            "Himesh Reshmiya","Pritam",
            "Arman Malik","Arjit singh",
            4)
        questionList.add(q10)


        return questionList
    }
}