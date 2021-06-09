/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex33.Base;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class MagicBall {
    private static final List<String> answerCollection = List.of("Yes.", "No.", "Maybe.", "Ask again later.");
    private MagicBall() {}

    public static String getAnswer() {
        return answerCollection.get(ThreadLocalRandom.current().nextInt(0, answerCollection.size()));
    }
}
