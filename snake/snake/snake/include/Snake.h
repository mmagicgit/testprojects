#ifndef SNAKE_H
#define SNAKE_H

class Snake {
private:
	//The collision box of the snake
	SDL_Rect box[50];

	//The velocity of the snake
	int xVel, yVel;

	int length;

public:
	//Initializes the variables
	Snake();

	//Takes key presses and adjusts the snake's velocity
	void handle_input();

	//Moves the snake
	void move();

	//Shows the snake on the screen
	void show();
};

#endif // SNAKE_H
