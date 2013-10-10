#include "SDL/SDL.h"
#include "SDL/SDL_image.h"
#include <string>
#include "Snake.h"
#include "Timer.h"
#include "CollisionDetection.h"
#include "Goody.h"
#include "iostream"
using namespace std;

//Screen attributes
const int SCREEN_WIDTH = 640;
const int SCREEN_HEIGHT = 480;
const int SCREEN_BPP = 32;

//The frame rate
const int FRAMES_PER_SECOND = 10;


//The surfaces
SDL_Surface *square = NULL;
SDL_Surface *screen = NULL;


SDL_Surface *load_image( std::string filename ) {

    //The image that's loaded
    SDL_Surface* loadedImage = NULL;

    //The optimized surface that will be used
    SDL_Surface* optimizedImage = NULL;

    //Load the image
    loadedImage = IMG_Load( filename.c_str() );

    //If the image loaded
    if( loadedImage != NULL ) {
        //Create an optimized surface
        optimizedImage = SDL_DisplayFormat( loadedImage );

        //Free the old surface
        SDL_FreeSurface( loadedImage );

        //If the surface was optimized
        if( optimizedImage != NULL ) {
            //Color key surface
            SDL_SetColorKey( optimizedImage, SDL_SRCCOLORKEY, SDL_MapRGB( optimizedImage->format, 0, 0xFF, 0xFF ) );
        }
    }

    return optimizedImage;
}

void apply_surface( int x, int y, SDL_Surface* source, SDL_Surface* destination, SDL_Rect* clip = NULL ) {

    //Holds offsets
    SDL_Rect offset;

    //Get offsets
    offset.x = x;
    offset.y = y;

    //Blit
    SDL_BlitSurface( source, clip, destination, &offset );
}

bool init() {

    //Initialize all SDL subsystems
    if( SDL_Init( SDL_INIT_EVERYTHING ) == -1 ) {
        return false;
    }

    //Set up the screen
    screen = SDL_SetVideoMode( SCREEN_WIDTH, SCREEN_HEIGHT, SCREEN_BPP, SDL_SWSURFACE );

    //If there was an error in setting up the screen
    if( screen == NULL ) {
        return false;
    }

    //Set the window caption
    SDL_WM_SetCaption( "Snake", NULL );

    //If everything initialized fine
    return true;
}

bool load_files() {

    //Load the square image
    square = load_image( "square_small.bmp" );

    //If there was a problem in loading the square
    if( square == NULL ) {
        return false;
    }

    //If everything loaded fine
    return true;
}

void clean_up() {

    //Free the surface
    SDL_FreeSurface( square );

    //Quit SDL
    SDL_Quit();
}

int main( int argc, char* args[] ) {
    //Quit flag
    bool quit = false;

    Snake mySnake(200, SDLK_UP, SDLK_DOWN, SDLK_LEFT, SDLK_RIGHT, "Player 1");
    Snake mySnake2(300, SDLK_w, SDLK_s, SDLK_a, SDLK_d, "Player 2");

    //The frame rate regulator
    Timer fps;

    //Initialize
    if( init() == false ) {
        return 1;
    }

    //Load the files
    if( load_files() == false ) {
        return 1;
    }

    Goody* goodies[100];
    int goodiesCount = 0;


    SDL_Event event;

    int loop = 0;

    //While the user hasn't quit
    while( quit == false ) {
        //Start the frame timer
        fps.start();

        //While there's events to handle
        while( SDL_PollEvent( &event ) ) {
            //Handle events for the snake
            mySnake.handle_input(event);
            mySnake2.handle_input(event);

            //If the user has Xed out the window
            if( event.type == SDL_QUIT ) {
                //Quit the program
                quit = true;
            }
        }

         mySnake.move();
         mySnake2.move();

        //Fill the screen white
        SDL_FillRect( screen, &screen->clip_rect, SDL_MapRGB( screen->format, 0xFF, 0xFF, 0xFF ) );

        if(loop%50==0) {
            goodies[goodiesCount] = new Goody();
            goodiesCount++;
        }


        for(int i=0; i < goodiesCount; i++) {
            if(goodies[i]->isActive()) {
                SDL_Rect goodyBox = goodies[i]->getBox();
                SDL_FillRect( screen, &goodyBox, SDL_MapRGB( screen->format, 0x00, 0xCD, 0x00 ) );
                if(CollisionDetection::hasCollision(mySnake.getBox(0), goodyBox)) {
                    mySnake.addBox();
                    goodies[i]->setActive(false);
                }
                if(CollisionDetection::hasCollision(mySnake2.getBox(0), goodyBox)) {
                    mySnake2.addBox();
                    goodies[i]->setActive(false);
                }
            }
        }

        //Show the snake on the screen
        for(int i = 0; i<mySnake.getLength(); i++) {
            apply_surface( mySnake.getBox(i).x, mySnake.getBox(i).y, square, screen );
        }
        for(int i = 0; i<mySnake2.getLength(); i++) {
            apply_surface( mySnake2.getBox(i).x, mySnake2.getBox(i).y, square, screen );
        }


        //Check collision between snakes
        for(int i=1; i < mySnake.getLength();i++) {
            if(CollisionDetection::hasCollision(mySnake.getBox(0), mySnake2.getBox(i))) {
                cout << mySnake.getName() << " has lost";
                exit(0);
            }
        }
        for(int i=1; i < mySnake2.getLength();i++) {
            if(CollisionDetection::hasCollision(mySnake2.getBox(0), mySnake.getBox(i))) {
                cout << mySnake2.getName() << " has lost";
                exit(0);
            }
        }

        //Update the screen
        if( SDL_Flip( screen ) == -1 ) {
            return 1;
        }

        //Cap the frame rate
        if( fps.get_ticks() < 1000 / FRAMES_PER_SECOND ) {
            SDL_Delay( ( 1000 / FRAMES_PER_SECOND ) - fps.get_ticks() );
        }
        loop++;
    }

    clean_up();

    return 0;
}

