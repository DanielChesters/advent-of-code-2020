package xyz.coincoin.adventofcode2020

class Day03 : Day {
    override fun part1(input: List<String>): Long {
        val forest: Array<CharArray> = mapInputToForest(input)
        val walkedForest = walkInForest(forest)
        return countX(walkedForest)
    }

    override fun part2(input: List<String>): Long =
        listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2)).map { (stepX, stepY) ->
            val forest: Array<CharArray> = mapInputToForest(input, stepX = stepX)
            val walkedForest = walkInForest(forest, stepX = stepX, stepY = stepY)
            countX(walkedForest)
        }.fold(1) { acc, i -> acc * i }

    private fun mapInputToForest(input: List<String>, stepX: Int = 3): Array<CharArray> {
        val sizeY = input.count()
        val sizeX = input.first().count()

        val time = stepX * ((sizeY / sizeX) + 1)

        return input.map { row ->
            row.repeat(time).toCharArray()
        }.toTypedArray()
    }

    private fun walkInForest(
        forest: Array<CharArray>,
        posX: Int = 0,
        posY: Int = 0,
        stepX: Int = 3,
        stepY: Int = 1
    ): Array<CharArray> {
        val maxY = forest.count()
        val newX = posX + stepX
        val newY = posY + stepY
        val stepForest = forest.mapIndexed { y, row ->
            row.mapIndexed { x, char ->
                if (x == newX && y == newY) {
                    when (char) {
                        '#' -> 'X'
                        '.' -> 'O'
                        else -> char
                    }
                } else {
                    char
                }
            }.toCharArray()
        }.toTypedArray()
        return if (newY >= maxY) {
            stepForest
        } else {
            walkInForest(stepForest, newX, newY, stepX, stepY)
        }
    }

    private fun countX(forest: Array<CharArray>): Long = forest.sumOf { row ->
        row.count { char ->
            char == 'X'
        }
    }.toLong()
}

fun main() {
    val day03 = Day03()
    val input = readInput("Day03")

    println("part 1: ${day03.part1(input)}")
    println("part 2: ${day03.part2(input)}")
}