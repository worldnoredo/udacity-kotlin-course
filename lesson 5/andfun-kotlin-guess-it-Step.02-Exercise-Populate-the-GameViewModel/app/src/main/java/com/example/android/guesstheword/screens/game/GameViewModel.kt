/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel


/**
 * ViewModel containing all the logic needed to run the game
 */
class GameViewModel : ViewModel() {
    // The current word
    var word = ""

    // The current score
    var score = 0
    var endgame = false
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    // TODO (06) Once you've copied over the variables and methods, remove any code referring back
    // to the GameFragment. You can also clean up the log statements from the last step.

    init {
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }
    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }
    /**
     * Moves to the next word in the list
     */
    /**
     * Called when the game is finished
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            endgame = true
        } else {
            word = wordList.removeAt(0)
        }
    }
    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }


}