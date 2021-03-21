fun leftChild(index: Int): Int = 2 * (index + 1) - 1

fun rightChild(index: Int): Int = 2 * (index + 1)

fun parent(index: Int): Int = (index + 1) / 2 - 1

fun heaplify(
    data: IntArray,
    tail: Int = data.size - 1
) {
    if (data.size < 2) return

    var i = tail
    while (i in 0..tail) {
        heaplifyAtIndex(data, i, tail)

        i--
    }
}

fun heaplifyAtIndex(data: IntArray, index: Int, tail: Int) {
    if (index < 0 || index > tail) return

    val leftChild = leftChild(index)
    val rightChild = rightChild(index)

    if (rightChild in 0..tail) {
        var greaterChild = if (data[leftChild] > data[rightChild]) leftChild else rightChild

        if (data[greaterChild] > data[index]) {
            swap(data, greaterChild, index)

            heaplifyAtIndex(data, greaterChild, tail)
        }
    } else if (leftChild in 0..tail) {
        if (data[leftChild] > data[index]) {
            swap(data, leftChild, index)


            heaplify(data, leftChild)
        }
    }
}

fun heapSort(data: IntArray) {
    if (data.size < 2) return

    var tail = data.size - 1
    do {
        heaplify(data, tail)

        swap(data, 0, tail)

        tail--
    } while (isValidIndex(data, tail))
}
