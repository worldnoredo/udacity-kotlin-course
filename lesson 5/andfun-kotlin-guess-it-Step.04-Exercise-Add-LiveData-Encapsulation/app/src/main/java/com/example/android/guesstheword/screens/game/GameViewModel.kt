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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * ViewModel containing all the logic needed to run the game
 */
class GameViewModel : ViewModel() {
    var endgame = false
    // TODO (01) Make an internal and external version of the word and score
    // The internal version should be a MutableLiveData, have an underscore in front of its' name
    // and be private
    // The external version should be a LiveData
    // TODO (02) Make a backing property for the external version that returns the internal
    // MutableLiveData as a LiveData

    // The current word
    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() {
           return _word
        }

    // The current score
    private val _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() {
            return _score
        }
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    // TODO (03) Use the internal version (the MutableLiveData) of _score and _word in this class
    init {
        resetList()
        nextWord()
        _score.value = 0
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
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            // gameFinished() should happen here
            endgame = true
        } else {
            _word.value = wordList.removeAt(0)
        }
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        _score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        nextWord()
    }
}
