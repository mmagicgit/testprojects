#include "SDL/SDL.h"

class Goody {

    private:

    bool active;
    SDL_Rect box;
    int xPosition, yPosition;

    public:

    Goody();
    void setActive(bool isActive);
    bool isActive();
    SDL_Rect getBox();
};
