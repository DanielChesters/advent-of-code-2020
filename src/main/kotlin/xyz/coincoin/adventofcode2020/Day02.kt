package xyz.coincoin.adventofcode2020

data class PasswordLine(
    val min: Int,
    val max: Int,
    val char: Char,
    val password: String,
)

class Day02 : Day {
    override fun part1(input: List<String>): Long {
        val passwordLines = getPasswordLines(input)
        val validatedPasswordLines = validatePasswordLines(passwordLines)
        return validatedPasswordLines.count().toLong()
    }

    override fun part2(input: List<String>): Long {
        val passwordLines = getPasswordLines(input)
        val validatedPasswordLines = validatePasswordLinesAlt(passwordLines)
        return validatedPasswordLines.count().toLong()
    }

    private fun validatePasswordLines(passwordLines: List<PasswordLine>): List<PasswordLine> =
        passwordLines.filter { passwordLine ->
            val count = passwordLine.password.count { c -> c == passwordLine.char }
            count in passwordLine.min..passwordLine.max
        }

    private fun validatePasswordLinesAlt(passwordLines: List<PasswordLine>): List<PasswordLine> =
        passwordLines.filter { passwordLine ->
            (passwordLine.password[passwordLine.min - 1] == passwordLine.char
                    && passwordLine.password[passwordLine.max - 1] != passwordLine.char)
                    || (passwordLine.password[passwordLine.min - 1] != passwordLine.char
                    && passwordLine.password[passwordLine.max - 1] == passwordLine.char)
        }

    private fun getPasswordLines(input: List<String>): List<PasswordLine> {
        val regex = "(\\d+)-(\\d+) ([a-z]): ([a-z]+)".toRegex()
        return input.mapNotNull {
            val matchGroup = regex.matchEntire(it)?.groupValues
            if (matchGroup != null) {
                val number1 = matchGroup[1].toInt()
                val number2 = matchGroup[2].toInt()
                val char = matchGroup[3].toCharArray().first()
                val password = matchGroup[4]
                if (number1 <= number2) PasswordLine(number1, number2, char, password)
                else PasswordLine(number2, number1, char, password)
            } else null
        }
    }
}

fun main() {
    val day02 = Day02()
    val input = readInput("Day02")

    println("part 1 : ${day02.part1(input)}")
    println("part 2 : ${day02.part2(input)}")
}