package com.example.trungnguyen.interviewpratice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        println("Result: ${v2FirstDuplicate(arrayOf(1, 2, 3, 3, 2, 6).toMutableList())}")
//        println("Result: ${firstNotRepeatingCharacter("abacabaabacaba")}")
//        println("Result: ${rotateImage(arrayOf(arrayOf(1, 2, 3).toMutableList(),
//                arrayOf(4, 5, 6).toMutableList(), arrayOf(7, 8, 9).toMutableList()).toMutableList())}")

        rotateImage(arrayOf(arrayOf(1, 2, 3).toMutableList(),
                arrayOf(4, 5, 6).toMutableList(), arrayOf(7, 8, 9).toMutableList()).toMutableList())
    }

    private fun v1FirstDuplicate(a: MutableList<Int>): Int {
        var returnNum = a.size
        var tempIndex = -1
        var numOfDuplicate = 0
        for (index in 0 until a.size) {
            for (index1 in (index + 1) until a.size) {
                if (a[index] == a[index1]) {
                    if (tempIndex != -1 && tempIndex != index1) continue
                    tempIndex = index1
                    if (index1 < returnNum)
                        returnNum = index1
                    numOfDuplicate++
                }
            }
            tempIndex = -1
        }
        return if (numOfDuplicate == 0) return -1
        else a[returnNum]
    }

    private fun v2FirstDuplicate(a: MutableList<Int>): Int {
        var tempIndex = -1
        val hashSet = HashSet<Int>()
        for (index in 0 until a.size) {
            if (hashSet.isEmpty()) {
                hashSet.add(a[index])
            } else {
                if (hashSet.contains(a[index])) {
                    if (tempIndex == -1)
                        tempIndex = index
                    else if (index < tempIndex)
                        tempIndex = index
                } else hashSet.add(a[index])
            }
        }
        return if (tempIndex == -1) -1
        else a[tempIndex]
    }

    private fun firstNotRepeatingCharacter(s: String): Char {
        val hashSet = HashSet<Char>()
        var tempChar = '_'
        for (index in 0 until s.length) {
            var temp = 0
            if (hashSet.contains(s[index])) continue
            for (index1 in (index + 1) until s.length) {
                if (s[index] == s[index1]) {
                    hashSet.add(s[index])
                    temp++
                    break
                }
            }
            if (temp == 0) {
                tempChar = s[index]
                break
            }
            tempChar = '_'
        }
        return tempChar
    }

    private fun rotateImage(a: MutableList<MutableList<Int>>) {
        val b = a
        val tempSize = a.size - 1
        for (parentIndex in 0 until a.size) {
            for (childIndex in 0 until a[parentIndex].size) {
                a[parentIndex][childIndex] = b[tempSize - childIndex][parentIndex]
            }
        }
        println("Ahihi $a")
    }

//    fun removeKFromList(list: ListNode<Int>?, removeValue: Int): ListNode<Int>? {
//        while (true) {
//            if (list?.value == removeValue) {
//                list = list.next
//                break
//            }
//        }
//        return list
//    }
}