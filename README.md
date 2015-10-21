# HiVolts
This readme is for the AP Computer Science project HiVolts. HiVolts is a game where you move on a 12x12 grid, avoiding fences
and enemies.

The program is seperated into 4 classes. The GameStart class, the Grid class, the YouWin class, and the YouLose class. The
GameStart class is what is run to start the game. It opens a window that tells the player the controls, and how to win. At the
bottom of the window is a button that, when clicked, starts the game by opening the Grid class main. Grid might be a bad name for
the class because it does everything else in the game! I originally planned to have several more classes, and Grid was to only
contain code for the creation of the Grid, but it turned into having so much more. Grid creates the cells and the grid, then
randomly spawns the characters. Grid also contains the code that allows you to move, and the code that has the mhos move
correctly. When you hit a fence or a mho, it opens the YouLose class. This class displays a window that says "Sorry, You Lost!
Would you like to continue?". Below that are two buttons. Yes starts the game again by going back to the Grid class, and no
closes all the open windows. If all the mhos die, YouWin opens, and it does the same as YouLose, but says "You Win!" instead.
There are no errors in my code as far as I know. The only thing I wish I could have figured out was how to close the previous
game when you click play again. The ways I attempted ended up closing every window, requiring you to run the program again.

Major Challenges/Acknowledgements: The creation of the grid. I didnt really know how to create the grid at first and was stuck. 
I never thought about using a 2D grid, until I asked Albert Ford for help. He probably does not remember, but he suggested using
one, and from then on, everything was pretty easy. The other challenge was figuring how to make the mhos move, but that wasnt too
hard. I'll be honest, I had a lot of problems at first, because I was trying to do it all in my head. So reminder to myself in 
the future: remember what dad said and write down psuedo-code before continuing.
