fun quickSort(
    data: IntArray,
    start: Int = 0,
    end: Int = data.size - 1
) {
    if (data.size < 2) return

    val partitionIndex = partition(data, start, end)
    if (partitionIndex > start + 1
        && isValidIndex(data, partitionIndex - 1)) quickSort(data, start, partitionIndex - 1)

    if (partitionIndex < end - 1
        && isValidIndex(data, partitionIndex + 1)) quickSort(data, partitionIndex + 1, end)
}

fun partition(
    data: IntArray,
    start: Int = 0,
    end: Int = data.size - 1
): Int {
    if (data.size < 2) return 0

    val pivot = data[(end - start) / 2 + start]
    var left = start;
    var right = end

    while (left < right) {
        while (isValidIndex(data, left) && data[left] < pivot) {
            left++
        }

        while (isValidIndex(data, right) && data[right] > pivot) {
            right--
        }

        if (left < right) {
            swap(data, left, right)
        }
    }

    return left
}

fun isValidIndex(data: IntArray, index: Int): Boolean =
    index >= 0 && index < data.size

fun swap(data: IntArray, left: Int, right: Int) {
    if (!isValidIndex(data, left) || !isValidIndex(data, right)) return

    val temp = data[left]
    data[left] = data[right]
    data[right] = temp
}

fun quickSort(data: List<Int>): List<Int> = if (data.size < 2) data else {
    val pivot = data[data.size / 2]

    quickSort(data.filter { it < pivot }) +
            data.filter { it == pivot } +
            quickSort(data.filter { it > pivot })
}

fun mergeSort(data: List<Int>): List<Int> = if (data.size < 2) data else {
    val mid = data.size / 2
    val left = mergeSort(data.subList(0, mid))
    val right = mergeSort(data.subList(mid, data.size))

    mergeSortedList(left, right)
}

fun mergeSortedList(left: List<Int>, right: List<Int>): List<Int> {
    if (left.isEmpty()) return right
    if (right.isEmpty()) return left

    var i = 0;
    var j = 0;
    var result = mutableListOf<Int>()

    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            result.add(left[i++])
        } else {
            result.add(right[j++])
        }
    }

    while (i < left.size) {
        result.add(left[i++])
    }

    while (j < right.size) {
        result.add(right[j++])
    }
    return result
}

fun insertionSort(data: List<Int>): List<Int> {
    if (data.size < 2) return data
    val result = mutableListOf<Int>()

    for (source in data) {
        var added = false

        for (j in result.indices) {
            if (source <= result[j]) {
                result.add(j, source)
                added = true
                break
            }
        }

        if (!added) result.add(source)
    }

    return result
}

fun bubbleSort(data: IntArray): IntArray {
    if (data.size < 2) return data

    var right = data.size - 1
    while (isValidIndex(data, right)) {
        var left = 0
        while (isValidIndex(data, left + 1) && left < right) {
            if (data[left] > data[left + 1]) {
                swap(data, left, left + 1)
            }

            left++
        }

        right--
    }

    return data
}

fun selectionSort(data: IntArray): IntArray {
    if (data.size < 2) return data

    var left = 0

    while (isValidIndex(data, left)) {
        var min = left
        var index = left + 1

        while (isValidIndex(data, index)) {
            if (data[index] < data[min]) {
                min = index
            }
            index++
        }

        swap(data, left++, min)
    }

    return data
}
