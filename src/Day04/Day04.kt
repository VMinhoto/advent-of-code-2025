package Day04

import org.jetbrains.kotlinx.multik.api.mk
import org.jetbrains.kotlinx.multik.api.ndarray
import org.jetbrains.kotlinx.multik.ndarray.data.get
import org.jetbrains.kotlinx.multik.ndarray.data.set
import org.jetbrains.kotlinx.multik.ndarray.operations.sum
import println
import readInput
import kotlin.time.measureTime

fun main() {
    fun part1(input: List<String>): Int {
        var result: Int = 0

        val array = input.map { row ->
            row.map { char ->
                if (char == '@') 1 else 0
            }.toIntArray()
        }.toTypedArray()

        val multikArray = mk.ndarray(array)

        for (index in multikArray.multiIndices){
            if(multikArray[index] == 1){
                val i = index[0]
                val j = index[1]
                val leftBoundI = (i-1).coerceAtLeast(0)
                val rightBoundI = (i+1).coerceAtMost(multikArray.shape[0]-1)
                val leftBoundJ = (j-1).coerceAtLeast(0)
                val rightBoundJ = (j+1).coerceAtMost(multikArray.shape[1]-1)
                val slice = multikArray[leftBoundI..rightBoundI, leftBoundJ..rightBoundJ]
                val sum = slice.sum() - 1
                if (sum<4){
                    result+=1
                }
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result: Int = 0

        val array = input.map { row ->
            row.map { char ->
                if (char == '@') 1 else 0
            }.toIntArray()
        }.toTypedArray()

        val multikArray = mk.ndarray(array)


        val indexList: MutableList<IntArray> = mutableListOf(intArrayOf(0,0))
        while (indexList.isNotEmpty()){
            indexList.clear()
            for (index in multikArray.multiIndices) {
                if (multikArray[index] == 1) {
                    val i = index[0]
                    val j = index[1]
                    val leftBoundI = (i - 1).coerceAtLeast(0)
                    val rightBoundI = (i + 1).coerceAtMost(multikArray.shape[0] - 1)
                    val leftBoundJ = (j - 1).coerceAtLeast(0)
                    val rightBoundJ = (j + 1).coerceAtMost(multikArray.shape[1] - 1)
                    val slice = multikArray[leftBoundI..rightBoundI, leftBoundJ..rightBoundJ]
                    val sum = slice.sum() - 1
                    if (sum < 4) {
                        result += 1
                        indexList.add(index.copyOf())
                    }
                }
            }
            indexList.forEach { index ->
                multikArray[index] = 0
            }
        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 3)

    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day04/Day04_test")
    check(part1(testInput) == 13)
    check(part2(testInput) == 43)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day04/Day04_test")

    val time1 = measureTime {
        part1(input)
    }
    val time2 = measureTime {
        part2(input)
    }
    println("Time taken fun 1: $time1; Time taken fun 2: $time2")
    part1(input).println()
    part2(input).println()
}
