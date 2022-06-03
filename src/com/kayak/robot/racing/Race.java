package com.kayak.robot.racing;

import com.kayak.robot.Robot;
import com.kayak.robot.RobotCommand;

import java.util.*;

public class Race {

    Map<Robot, List<RobotCommand>> racers = new HashMap<>();
    Collection<RacerThreadListener> fans = new ArrayList<>();


    public Race(Map<Robot,List<RobotCommand>> racers,Collection<RacerThreadListener> fans) {
        super();
        this.racers = racers;
    }

    public Race(Collection<Robot> racers,Collection<RobotCommand> raceCommands) {
        //loop through and set each racers command to these commands
    }

    public void race() {

    }


}
