package com.example.quizgame.data

data class Questions (
    val question: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val correctAnswer: String
)

val questions = listOf<Questions>(
    Questions("Who was the first man on the moon?", "Buzz Aldrin", "Neil Armstrong", "Gordon Ramsay", "Lionel Messi", "Neil Armstrong"),
    Questions("Which country invented ice cream?", "Israel", "USA", "China", "Japan", "China"),
    Questions("From which country does Gouda cheese originate?", "Netherlands", "Albania", "Chile", "Croatia", "Netherlands"),
    Questions("Which Disney Princess talks to the most animals?", "Ariel", "Snow White", "Belle", "Mulan", "Snow White"),
    Questions("How many colors are there in the rainbow?", "7", "2", "5", "8", "7"),
    Questions("What's the smallest country in the world?", "Switzerland", "Germany", "Sweden", "Vatican City", "Vatican City"),
    Questions("What country has the most natural lakes?", "Canada", "Germany", "Cyprus", "Japan", "Canada"),
    Questions("In what country would you find Lake Bled?", "Jordan", "Slovenia", "Canada", "Egypt", "Slovenia"),
    Questions("How many hearts does an octopus have?", "3", "2", "1", "6", "3"),
    Questions("How many legs does a spider have?", "6", "8", "11", "4", "8"),
    Questions("How long do elephant pregnancies last?", "22 months", "34 months", "12 weeks", "100 days", "22 months"),
    Questions("What type of animal is a Flemish giant?", "Cat", "Rabbit", "Dog", "Fish", "Rabbit"),
    Questions("What is the hottest planet in the solar system?", "Venus", "Earth", "Mars", "Neptune", "Venus"),
    Questions("What is the nearest planet to the sun?", "Mercury", "Mars", "Neptune", "Jupiter", "Mercury"),
    Questions("What is the largest planet in the solar system?", "Jupiter", "Mars", "Earth", "Neptune", "Jupiter"),
    Questions("How many teeth does an adult human have?", "24", "32", "33", "20", "32"),
    Questions("What color is your blood when it’s inside your body?", "Red", "Blue", "Green", "Black", "Red")
)