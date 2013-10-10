#include <SDL/SDL.h>
#include <SDL/SDL_net.h>
#include <stdlib.h>


void init_sdl (void)
{
    if (SDL_Init (SDL_INIT_VIDEO) < 0)
        exit (-1);
    atexit (SDL_Quit);
}

TCPsocket init_net (void)
{
    IPaddress addr;
    if (SDLNet_Init () < 0)
    {
        printf ("ERR Net: %s\n", SDLNet_GetError ());
        exit (-1);
    }
    if (SDLNet_ResolveHost (&addr, "localhost", 1234) < 0)
    {
        printf ("ERR ResolveHost: %s\n", SDLNet_GetError ());
        SDLNet_Quit ();
        exit (-1);
    }
    TCPsocket socket = SDLNet_TCP_Open (&addr);
    if (socket == NULL)
    {
        printf ("ERR TCP_Open: %s\n", SDLNet_GetError ());
        SDLNet_Quit ();
        exit (-1);
    }

    return socket;
}

int main (void)
{
    int maxread;
    int received = -1;
    init_sdl ();
    TCPsocket client = init_net ();
    printf ("Client-Socket ist offen\n");

    int countdown = 5;
    while(countdown > 0) {
        SDLNet_TCP_Recv (client, &received, sizeof (int));
        printf("%d\n", received);
        countdown--;
    }



    /* zurückschicken */
    //printf ("send back\n");
//    rect->x = 1;
//    rect->y = 2;
//    rect->w = 100;
//    rect->h = 200;
//    SDLNet_TCP_Send (client, rect, sizeof (SDL_Rect));
    SDLNet_TCP_Close (client);
    return 0;
}

