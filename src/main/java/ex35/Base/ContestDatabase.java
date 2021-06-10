/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex35.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContestDatabase {
    private ArrayList<Contestant> contestants;

    public ContestDatabase() {
        contestants = new ArrayList<>();
    }

    public ContestDatabase(List<Contestant> contestants) {
        this();
        this.addContestants(contestants);
    }

    public void addContestants(List<Contestant> contestants) {
        this.contestants.addAll(contestants);
    }

    public void addContestant(Contestant contestant) {
        this.contestants.add(contestant);
    }

    public void removeContestant(Contestant contestant) {
        this.contestants.remove(contestant);
    }

    public Contestant findContestant(int index) {
        return contestants.get(index);
    }

    public Contestant findContestant(Contestant contestant)
            throws NoSuchElementException {
        return this.contestants.stream().filter(o -> o.getName().equals(contestant.getName())).findFirst().orElseThrow();
    }

    public int getContestantDBSize() {
        return contestants.size();
    }
}
