package Day01

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var currentValue: Int = 50
        var count: Int = 0
        for (i in input) {
            val operation: Char = i[0]
            val value: Int = i.substring(1).toInt()
            if (operation == 'L'){
                currentValue = (currentValue-value+100)%100
            } else {
                currentValue = (currentValue+value)%100
            }
            if (currentValue == 0) {
                count++
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var currentValue: Int = 50
        var count: Int = 0
        for (i in input) {
            val operation: Char = i[0]
            val value: Int = i.substring(1).toInt()
            for (i in 1..value){
                if (operation == 'L'){
                    currentValue = (currentValue-1+100)%100
                }
                if (operation == 'R'){
                    currentValue = (currentValue+1)%100
                }
                if (currentValue == 0){
                    count++
                }
            }

        }
        return count
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 3)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01/Day01_test")
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01/Day01")
    part1(input).println()
    part2(input).println()
}
