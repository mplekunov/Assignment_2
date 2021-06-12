/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex35.Base;

public class Contestant {
    private String name;

    public Contestant() {}

    public Contestant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Contestant contestant))
            return false;

        return this.getName().equals(contestant.getName());
    }
}
