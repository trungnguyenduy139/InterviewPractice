package com.example.trungnguyen.interviewpratice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rotateImage(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    int[][] rotateImage(int[][] a) {
        int[][] b = new int[a.length][a[0].length];
        int tempSize = a.length - 1;
        for (int parentIndex = 0; parentIndex < a.length; parentIndex++) {
            for (int childIndex = 0; childIndex < a[parentIndex].length; childIndex++) {
                a[parentIndex][childIndex] = b[tempSize - childIndex][parentIndex];
            }
        }
        return a;
    }

    boolean sudoku2(char[][] grid) {
        ArrayList<HashSet<Character>> colHashSet = new ArrayList<>();
        for (int hashIndex = 0; hashIndex < 9; hashIndex++) {
            colHashSet.add(hashIndex, null);
        }

        HashSet<Character> rowHashSet = new HashSet<>();
        //check 3x3 box exists
        for (int rowIndex = 0; rowIndex < 3; ++rowIndex) {
            for (int colIndex = 0; colIndex < 3; ++colIndex) {
                Set<Character> boxExists = new HashSet<>();
                for (int k = 0; k < 3; ++k) {
                    int row = rowIndex * 3 + k;
                    for (int k2 = 0; k2 < 3; ++k2) {
                        int col = colIndex * 3 + k2;
                        char tmpChar = grid[row][col];
                        if (tmpChar != '.') {
                            if (boxExists.contains(tmpChar)) {
                                return false;
                            }
                            boxExists.add(tmpChar);
                        }
                    }
                }
            }
        }

        //check row and column exists
        for (char[] aGrid : grid) {
            for (int childIndex = 0; childIndex < aGrid.length; childIndex++) {
                if (colHashSet.get(childIndex) == null)
                    colHashSet.set(childIndex, new HashSet<Character>());
                char tmpElement = aGrid[childIndex];
                if (tmpElement != '.') {
                    if (!rowHashSet.contains(tmpElement)) rowHashSet.add(tmpElement);
                    else return false;
                    if (colHashSet.get(childIndex).contains(tmpElement)) return false;
                    else colHashSet.get(childIndex).add(tmpElement);
                }
            }
            if (rowHashSet.size() > 0)
                rowHashSet.clear();
        }
        return true;
    }
}
