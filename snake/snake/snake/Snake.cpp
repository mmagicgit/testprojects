#include "SDL/SDL.h"
#include "Snake.h"
#include "iostream"
#include "CollisionDetection.h"

const int SQUARE_WIDTH = 10;
const int SQUARE_HEIGHT = 10;

Snake::Snake(int startX, SDLKey upKey, SDLKey downKey, SDLKey leftKey, SDLKey rightKey, string playerName) {
    length = 5;

    up = upKey;
    down = downKey;
    left = leftKey;
    right = rightKey;

    name = playerName;

    int startY = 100;
    for(int i=0; i<length; i++) {
        box[i].w = SQUARE_WIDTH;
        box[i].h = SQUARE_HEIGHT;
        box[i].y = startX;
        box[i].x = startY;
        startY = startY - 10;
    }
    //Initialize the velocity
    xVel = SQUARE_WIDTH;
    yVel = 0;
}

void Snake::handle_input(SDL_Event event) {
    //If a key was pressed
    if( event.type == SDL_KEYDOWN ) {
        //Adjust the velocity
        if(event.key.keysym.sym == up) {
            yVel = -SQUARE_WIDTH;
            xVel = 0;
        }
        if(event.key.keysym.sym == down) {
            yVel = +SQUARE_WIDTH;
            xVel = 0;
        }
        if(event.key.keysym.sym == left) {
            xVel = -SQUARE_WIDTH;
	        yVel = 0;
        }
        if(event.key.keysym.sym == right) {
            xVel = +SQUARE_WIDTH;
            yVel = 0;
        }
    }
}

void Snake::move() {
    for(int i = length - 1; i > 0; i--) {
        box[i] = box[i-1];
    }

    //Move the snake head left or right
    box[0].x += xVel;

    //If the snake head went too far to the left or right
    if( ( box[0].x < 0 ) || ( box[0].x + SQUARE_WIDTH > 640 ) ) {
        cout << name << " has lost";
        exit(0);
    }

    //Move the snake head up or down
    box[0].y += yVel;

    //If the snake head went too far up or down
    if( ( box[0].y < 0 ) || ( box[0].y + SQUARE_HEIGHT > 480 ) ) {
        cout << name << " has lost";
        exit(0);
    }

    //Check if the snake head touches the snake's body
    for(int i=1; i < length;i++) {
        if(CollisionDetection::hasCollision(box[0], box[i])) {
            cout << name << " has lost";
            exit(0);
        }
    }
}

SDL_Rect Snake::getBox(int index) {
    return box[index];
}

int Snake::getLength() {
    return length;
}

void Snake::addBox() {
    box[length].w = SQUARE_WIDTH;
    box[length].h = SQUARE_HEIGHT;
    box[length].x = box[length-1].x - SQUARE_WIDTH;
    box[length].y = box[length-1].y;
    length++;
}

string Snake::getName() {
    return name;
}
