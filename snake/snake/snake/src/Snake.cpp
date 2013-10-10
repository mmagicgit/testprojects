#include "Snake.h"

Snake::Snake() {
	//Initialize the offsets
	box[0].x = 100;
	box[0].y = 100;
	box[1].x = 90;
	box[1].y = 100;
	box[2].x = 80;
	box[2].y = 100;
	box[3].x = 70;
	box[3].y = 100;
	box[4].x = 60;
	box[4].y = 100;

	//Set the square's dimentions
	box[0].w = SQUARE_WIDTH;
	box[0].h = SQUARE_HEIGHT;
	box[1].w = SQUARE_WIDTH;
	box[1].h = SQUARE_HEIGHT;
	box[2].w = SQUARE_WIDTH;
	box[2].h = SQUARE_HEIGHT;
	box[3].w = SQUARE_WIDTH;
	box[3].h = SQUARE_HEIGHT;
	box[4].w = SQUARE_WIDTH;
	box[4].h = SQUARE_HEIGHT;

	//Initialize the velocity
	xVel = SQUARE_WIDTH;
	yVel = 0;

	length = 5;
}

void Snake::handle_input() {
	//If a key was pressed
	if (event.type == SDL_KEYDOWN) {
		//Adjust the velocity
		switch (event.key.keysym.sym) {
		case SDLK_UP:
			yVel = -SQUARE_WIDTH;
			xVel = 0;
			break;
		case SDLK_DOWN:
			yVel = +SQUARE_WIDTH;
			xVel = 0;
			break;
		case SDLK_LEFT:
			xVel = -SQUARE_WIDTH;
			yVel = 0;
			break;
		case SDLK_RIGHT:
			xVel = +SQUARE_WIDTH;
			yVel = 0;
			break;
		}
	}
}

void Snake::move() {
	box[4] = box[3];
	box[3] = box[2];
	box[2] = box[1];
	box[1] = box[0];

	//Move the square left or right
	box[0].x += xVel;

	//If the square went too far to the left or right
	if ((box[0].x < 0) || (box[0].x + SQUARE_WIDTH > SCREEN_WIDTH)) {
		exit(0);
	}

	//Move the square up or down
	box[0].y += yVel;

	//If the square went too far up or down
	if ((box[0].y < 0) || (box[0].y + SQUARE_HEIGHT > SCREEN_HEIGHT)) {
		exit(0);
	}

}

void Snake::show() {
	//Show the square
	apply_surface(box[0].x, box[0].y, square, screen);
	apply_surface(box[1].x, box[1].y, square, screen);
	apply_surface(box[2].x, box[2].y, square, screen);
	apply_surface(box[3].x, box[3].y, square, screen);
	apply_surface(box[4].x, box[4].y, square, screen);
}
