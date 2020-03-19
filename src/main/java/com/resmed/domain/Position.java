package com.resmed.domain;

public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.direction = position.getDirection();
    }

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction =  direction;
    }

    public void change(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public Position getNextPosition() {
        Position newPosition = new Position(this);
        switch (this.direction) {
            case N:
                newPosition.change(0, 1);
                break;
            case E:
                newPosition.change(1, 0);
                break;
            case S:
                newPosition.change(0, -1);
                break;
            case W:
                newPosition.change(-1, 0);
                break;
        }
        return newPosition;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
