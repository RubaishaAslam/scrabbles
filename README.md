# scrabbles
In this assignment, you are provided with a text file consisting of all 279,496 words published in the 2019 version of the Collins Scrabble Word dictionary.
Given the letters of seven randomized Scrabble tiles, you must determine the set of scores that a player could possibly obtain by placing these tiles. We will be assuming three traits that differ slightly from the traditional game of Scrabble:
1. There is an unlimited amount of every letter within the scrabble bag, thus it is reasonable to assume (though incredibly unlikely) that you could obtain something like [‘A’, ‘A’, ‘A’, ‘A’, ‘A’, ‘A’, ‘A’].
2. You will be placing these tiles during the first turn on the board. Thus, you do not need to worry about combining your word with any pre-existing letters that might have already been placed on the Scrabble board.
3. Assume that there exist no word or letter bonuses. We will simply be basing the score off the tile values.
As an example, assume that your seven randomized tiles read:
{‘A’, ‘C’, ‘A’, ‘A’, ‘B’, ‘A’, ‘H’}
The output should be 1) a list of length n of words that can be created using these letters, and 2) a list of length n containing the scores (integers) for each of the words of length 1 ≤ m ≤ 7 that can be created using these letters (like ‘AA’, or ‘AAH’, which are both words within the Collins Scrabble Word dictionary, surprisingly). So two of the scores that will be in your score set for the above tile set are 2 (A (1) + A (1) = 2), and 6 (A (1) + A (1) + H (4) = 6).
