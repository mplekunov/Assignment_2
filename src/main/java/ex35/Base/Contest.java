/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex35.Base;

import java.util.concurrent.ThreadLocalRandom;

public final class Contest {
    private Contest() {}

    public static Contestant drawWinner(ContestDatabase contestDB) {
        try {
            return contestDB.findContestant(ThreadLocalRandom.current().nextInt(0, contestDB.getContestantDBSize()));
        } catch (IllegalArgumentException iae) {
            //When there are no contestants in the contestDB
            return null;
        }
    }
}
