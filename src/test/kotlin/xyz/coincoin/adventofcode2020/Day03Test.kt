package xyz.coincoin.adventofcode2020

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day03Test: ShouldSpec({
    val day03 = Day03()
    val input = readInput("Day03_test")

    should("give 7 for part 1") {
        day03.part1(input) shouldBe 7
    }

    should("give 336 for part 2") {
        day03.part2(input) shouldBe 336
    }
})