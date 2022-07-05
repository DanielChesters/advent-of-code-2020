package xyz.coincoin.adventofcode2020

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day02Test : ShouldSpec({
    val day02 = Day02()
    val input = readInput("Day02_test")

    should("give 2 for part 1") {
        day02.part1(input) shouldBe 2
    }

    should("give 1 for part 2") {
        day02.part2(input) shouldBe 1
    }
})