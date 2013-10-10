#include "SDL/SDL.h"
#include "Goody.h"
#include <time.h>

Goody::Goody() {
    srand( time(NULL) );
    box.x = (rand()%64) * 10; //TODO: random
    box.y = (rand()%48) * 10; //TODO: random
    box.w = 10;
    box.h = 10;
    active = true;
}

void Goody::setActive(bool isActive) {
    active = isActive;
}

bool Goody::isActive() {
    return active;
}

SDL_Rect Goody::getBox() {
    return box;
}
