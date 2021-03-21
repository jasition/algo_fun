import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class SortingTest : StringSpec({
    "Quick sort can sort numbers in ascending order" {
        forAll(
            row(listOf(4, 6, 2, 9, 1), listOf(1, 2, 4, 6, 9)),
            row(listOf(9, 1, 6, 4, 2), listOf(1, 2, 4, 6, 9)),
            row(listOf(6, 4, 1, 2, 9), listOf(1, 2, 4, 6, 9)),
            row(listOf(2, 9, 4, 1, 6), listOf(1, 2, 4, 6, 9)),
            row(listOf(1, 2, 9, 6, 4), listOf(1, 2, 4, 6, 9))
        ) { unsorted, expectedSorted ->
            quickSort(unsorted) shouldBe expectedSorted
        }
    }
    "Quick sort with array can sort numbers in ascending order" {
        forAll(
            row(intArrayOf(4, 6, 2, 9, 1), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(9, 1, 6, 4, 2), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(6, 4, 1, 2, 9), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(2, 9, 4, 1, 6), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(1, 2, 9, 6, 4), intArrayOf(1, 2, 4, 6, 9))
        ) { original, expectedSorted ->
            val clone = original.clone()
            quickSort(clone)

            clone shouldBe expectedSorted
        }
    }
    "Merge sort can sort numbers in ascending order" {
        forAll(
            row(listOf(4, 6, 2, 9, 1), listOf(1, 2, 4, 6, 9)),
            row(listOf(9, 1, 6, 4, 2), listOf(1, 2, 4, 6, 9)),
            row(listOf(6, 4, 1, 2, 9), listOf(1, 2, 4, 6, 9)),
            row(listOf(2, 9, 4, 1, 6), listOf(1, 2, 4, 6, 9)),
            row(listOf(1, 2, 9, 6, 4), listOf(1, 2, 4, 6, 9))
        ) { unsorted, expectedSorted ->
            mergeSort(unsorted) shouldBe expectedSorted
        }
    }
    "Heap sort can sort numbers in ascending order" {
        forAll(
            row(intArrayOf(4, 6, 2, 9, 1), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(9, 1, 6, 4, 2), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(6, 4, 1, 2, 9), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(2, 9, 4, 1, 6), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(1, 2, 9, 6, 4), intArrayOf(1, 2, 4, 6, 9))
        ) { original, expectedSorted ->
            val clone = original.clone()
            heapSort(clone)

            clone shouldBe expectedSorted
        }
    }
    "Insertion sort can sort numbers in ascending order" {
        forAll(
            row(listOf(4, 6, 2, 9, 1), listOf(1, 2, 4, 6, 9)),
            row(listOf(9, 1, 6, 4, 2), listOf(1, 2, 4, 6, 9)),
            row(listOf(6, 4, 1, 2, 9), listOf(1, 2, 4, 6, 9)),
            row(listOf(2, 9, 4, 1, 6), listOf(1, 2, 4, 6, 9)),
            row(listOf(1, 2, 9, 6, 4), listOf(1, 2, 4, 6, 9))
        ) { unsorted, expectedSorted ->
            insertionSort(unsorted) shouldBe expectedSorted
        }
    }
    "Bubble sort can sort numbers in ascending order" {
        forAll(
            row(intArrayOf(4, 6, 2, 9, 1), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(9, 1, 6, 4, 2), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(6, 4, 1, 2, 9), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(2, 9, 4, 1, 6), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(1, 2, 9, 6, 4), intArrayOf(1, 2, 4, 6, 9))
        ) { original, expectedSorted ->
            val clone = original.clone()
            bubbleSort(clone)

            clone shouldBe expectedSorted
        }
    }
    "Selection sort can sort numbers in ascending order" {
        forAll(
            row(intArrayOf(4, 6, 2, 9, 1), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(9, 1, 6, 4, 2), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(6, 4, 1, 2, 9), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(2, 9, 4, 1, 6), intArrayOf(1, 2, 4, 6, 9)),
            row(intArrayOf(1, 2, 9, 6, 4), intArrayOf(1, 2, 4, 6, 9))
        ) { original, expectedSorted ->
            val clone = original.clone()
            selectionSort(clone)

            clone shouldBe expectedSorted
        }
    }
    "Merge two sorted lists correctly" {
        forAll(
            row(listOf(1, 2, 4, 6, 9), listOf(), listOf(1, 2, 4, 6, 9)),
            row(listOf(1, 2, 4, 6), listOf(9), listOf(1, 2, 4, 6, 9)),
            row(listOf(1, 2, 6), listOf(4, 9), listOf(1, 2, 4, 6, 9)),
            row(listOf(1, 2), listOf(4, 6, 9), listOf(1, 2, 4, 6, 9)),
            row(listOf(2), listOf(1, 4, 6, 9), listOf(1, 2, 4, 6, 9)),
            row(listOf(), listOf(1, 2, 4, 6, 9), listOf(1, 2, 4, 6, 9)),
            row(listOf(1), listOf(2), listOf(1, 2)),
            row(listOf(1), listOf(), listOf(1)),
            row(listOf(), listOf(1), listOf(1)),
            row(listOf(), listOf(), listOf())
        ) { left, right, expectedMerged ->
            mergeSortedList(left, right) shouldBe expectedMerged
        }
    }
    "Partition a list by pivot correctly" {
        forAll(
            row(intArrayOf(), 0, intArrayOf()),
            row(intArrayOf(2), 0, intArrayOf(2)),
            row(intArrayOf(2, 5), 0, intArrayOf(2, 5)),
            row(intArrayOf(5, 2), 1, intArrayOf(2, 5)),
            row(intArrayOf(4, 2, 5), 0, intArrayOf(2, 4, 5)),
            row(intArrayOf(5, 2, 4), 0, intArrayOf(2, 5, 4)),
            row(intArrayOf(2, 4, 5), 1, intArrayOf(2, 4, 5)),
            row(intArrayOf(5, 4, 2), 1, intArrayOf(2, 4, 5)),
            row(intArrayOf(4, 5, 2), 2, intArrayOf(4, 2, 5)),
            row(intArrayOf(2, 5, 4), 2, intArrayOf(2, 4, 5)),
            row(intArrayOf(4, 2, 6, 9, 1), 3, intArrayOf(4, 2, 1, 6, 9))
        ) { original, expectedPartitionIndex, partitioned ->
            val clone = original.clone()
            partition(clone) shouldBe expectedPartitionIndex
            clone shouldBe partitioned
        }
    }
    "Heapify an array correctly" {
        forAll(
            row(intArrayOf(),  intArrayOf()),
            row(intArrayOf(2),  intArrayOf(2)),
            row(intArrayOf(2, 5),  intArrayOf(5, 2)),
            row(intArrayOf(5, 2),  intArrayOf(5, 2)),
            row(intArrayOf(4, 2, 5), intArrayOf(5, 2, 4)),
            row(intArrayOf(5, 2, 4), intArrayOf(5, 2, 4)),
            row(intArrayOf(2, 4, 5), intArrayOf(5, 4, 2)),
            row(intArrayOf(5, 4, 2), intArrayOf(5, 4, 2)),
            row(intArrayOf(4, 5, 2), intArrayOf(5, 4, 2)),
            row(intArrayOf(2, 5, 4), intArrayOf(5, 2, 4)),
            row(intArrayOf(10, 20, 15, 12, 40, 25, 18), intArrayOf(40, 20, 25, 12, 10, 15, 18))
        ) { original, expectedHeaplifed ->
            val clone = original.clone()
            heaplify(clone)
            clone shouldBe expectedHeaplifed
        }
    }
})
