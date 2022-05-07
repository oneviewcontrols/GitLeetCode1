package com.company.leetcode;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        Node.runTestCase();
    }
}

interface Reptile extends Callable<Reptile> {
    ReptileEgg lay();
}

class FireDragon implements Reptile {
    FireDragon() {
    }

    public ReptileEgg lay() {
        return new ReptileEgg(new FireDragon());
    }


    @Override
    public Reptile call() throws Exception {
        return new FireDragon();
    }
}


class ReptileEgg {
    private boolean hatched = false;
    private Callable reptile = null;
    public ReptileEgg(Callable<Reptile> createReptile) {
        reptile = createReptile;
    }

    public Reptile hatch() throws Exception {
        if (hatched == true ) {
            throw new IllegalStateException();
        }
        hatched = true;
        return (Reptile)reptile.call();
    }
}



