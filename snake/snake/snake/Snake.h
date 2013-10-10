using namespace std;
#include <string>

class Snake {
private:
	//The collision box of the snake
	SDL_Rect box[50];
	string name;
    SDLKey up;
    SDLKey down;
    SDLKey left;
    SDLKey right;
	int xVel, yVel;
	int length;

public:
	//Initializes the variables
	Snake(int startAtHeigt, SDLKey up, SDLKey down, SDLKey left, SDLKey right, string name);

	//Takes key presses and adjusts the snake's velocity
	void handle_input(SDL_Event event);

	//Moves the snake
	void move();

	//Shows the snake on the screen
	void show();

	SDL_Rect getBox(int index);

	int getLength();

    void addBox();

    string getName();

};


