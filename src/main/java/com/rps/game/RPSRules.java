package com.rps.game;

import java.util.logging.Logger;

public abstract class RPSRules {
    protected final Logger log = Logger.getLogger(getClass().getName());

    protected int[][] whoWinTab = {
            {0, 1, -1, -1, 1},
            {-1, 0, 1, 1, -1},
            {1, -1, 0, -1, 1},
            {1, -1, 1, 0, -1},
            {-1, 1, -1, 1, 0}
    };
    /*              player 1 ->
     * player 2 \/   |  rock   | paper  | scissors | lizard | spock
     * rock          |    0    |    1   |    -1    |   -1   |   1
     * paper         |   -1    |    0   |     1    |    1   |  -1
     * scissors      |    1    |   -1   |     0    |   -1   |   1
     * lizard        |    1    |   -1   |     1    |    0   |  -1
     * spock         |   -1    |    1   |    -1    |    1   |   0
     * */
}
