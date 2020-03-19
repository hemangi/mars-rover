package com.resmed.domain;

public class MarsRover {

    private Position position;

    public void move(Position newPosition) {
        if (newPosition != null) {
            this.position = newPosition;
        } else {
            throw new IllegalArgumentException("Provide correct position");
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public void rotateLeft() {
        Direction direction = this.position.getDirection();
        if (direction != null) {
            this.position.setDirection(direction.left());
        }
    }

    public void rotateRight() {
        Direction direction = this.position.getDirection();
        if (direction != null) {
            this.position.setDirection(direction.right());
        }
    }
}
