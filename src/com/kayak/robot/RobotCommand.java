package com.kayak.robot;

public abstract class RobotCommand {
    protected RobotImpl robot;

    public RobotCommand(RobotImpl robot) {
        super();
        this.robot = robot;
    }

    abstract public void execute();

}
