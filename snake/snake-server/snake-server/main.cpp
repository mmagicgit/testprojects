#include <SDL/SDL.h>
#include <SDL/SDL_net.h>
#include <stdlib.h>
#include <string>
using namespace std;


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
    if (SDLNet_ResolveHost (&addr, NULL, 1234) < 0)
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
    TCPsocket client = NULL;
    TCPsocket client2 = NULL;

//    SDL_Rect *rect;
//    int maxread;
    init_sdl ();
    TCPsocket server = init_net ();
    printf ("Server-Socket ist offen\n");
    while (client == NULL)
    {
        SDL_Delay (1000);
        client = SDLNet_TCP_Accept (server);
    }
    printf("Client 1 ist am Start.\n");

    while (client2 == NULL)
    {
        SDL_Delay (1000);
        client2 = SDLNet_TCP_Accept (server);
    }
    printf("Client 2 ist am Start.\n");

    //Countdown
    int countdown = 5;

    while (countdown > 0) {
        SDL_Delay (1000);
        SDLNet_TCP_Send (client,  &countdown, sizeof (countdown));
        SDLNet_TCP_Send (client2, &countdown, sizeof (countdown));
        countdown--;
    }

////    maxread = SDLNet_TCP_Recv (client, rect, sizeof (SDL_Rect));
////    printf ("Client1: I am Server. \n Read = %d\n", maxread);
////    printf ("x = %d, y = %d, w = %d, h = %d\n",
////            rect->x, rect->y, rect->w, rect->h);
////
////    maxread = SDLNet_TCP_Recv (client2, rect, sizeof (SDL_Rect));
////    printf ("Client2: I am Server. \n Read = %d\n", maxread);
////    printf ("x = %d, y = %d, w = %d, h = %d\n",
////            rect->x, rect->y, rect->w, rect->h);

    SDLNet_TCP_Close (client);
    SDLNet_TCP_Close (client2);
    SDLNet_TCP_Close (server);
    return 0;
}
