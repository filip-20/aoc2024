package day03

import java.io.File



fun main() {
    val input = File("day03/in03_all.txt").readLines()

    val regex = Regex("""(mul\(\d+,\d+\)|do\(\)|don't\(\))""")


    var sum = 0
    var addition = true
    for (i in input) {

        var matching = regex.findAll(i)
        println(matching.count())

        for (j in matching) {

            var curr = j.value

            println(curr)


            if (curr == "do()") {
                addition = true
            }

            if (curr == "don't()") {
                addition = false
            }

            if (curr.startsWith("mul") && addition) {
                var numbers = curr.substring(4,curr.length-1).split(",")

                sum += numbers[0].toInt() * numbers[1].toInt()

            }


        }
    }

    println(sum)

}
