package day02

import java.io.File

fun safe(numbers: List<Int>): Boolean {
    if (numbers.size < 2) return true

    val increasing = numbers[0] < numbers[1]
    for (i in 0 until numbers.size - 1) {
        val diff = numbers[i + 1] - numbers[i]
        if (diff == 0 || diff !in 1..3 && increasing || diff !in -3..-1 && !increasing) {
            return false
        }
    }
    return true
}

fun safeRemoved(numbers: List<Int>): Boolean {
    if (safe(numbers)) return true

    for (i in numbers.indices) {
        val modified = numbers.toMutableList()
        modified.removeAt(i)
        if (safe(modified)) return true
    }
    return false
}

fun main() {
    val input = File("day02/in02_all.txt").readLines().map { it.split(" ").map(String::toInt) }
    var sum = 0

    for (i in input) {
        if (safeRemoved(i)) {
            sum++
        }
    }

    println(sum)
}
