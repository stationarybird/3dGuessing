import java.util.Scanner;

public class GameSol {
  private String[][] grid;
  private int[] hurkeLoc;
  /* Make board instance variable and any others you may need */  
  
  /* Game constructor, initializes the board with size 10 by 10 
  */
  public GameSol(){
    String x = "ur mom";
  }
  
  /* Player calls this function to make their guess
  There are two parameters: x, y
  If correct return "Found Hurkle",
  Otherwise returns a string of where the hurkle is relative to the 
  guess, ie NW, SW, W, N, etc. */
  public String makeGuess(int x, int y){
    if(x == hurkeLoc[0] && y == hurkeLoc[1]){
      return "Found Hurkle";
    } 
    String r = "";
    if (hurkeLoc[1] > y) r+= "N";
    else if (hurkeLoc[1] < y) r+= "S";
    else r += " ";
    if (hurkeLoc[0] > x) r+= "E";
    else if (hurkeLoc[0] < x) r+= "W";
    else r += " ";
    return r;
  }

  /* Method that starts the game:
  1. Initialize a random location for the hurkle
  2. Stores the Hurkle location in the instance array
  3. Gives the player 5 tries to guess the Hurkle's location 
  4. Tells the player if they succeeded or not */
  public void playGame(){
    grid = new String[10][10];
    Scanner scan = new Scanner(System.in);
    hurkeLoc = new int[2];
    hurkeLoc[0] = (int) (Math.random() * 10);
    hurkeLoc[1] = (int) (Math.random() * 10);
    int x = 5;

    System.out.print(this);
    while(x > 0){
      System.out.println("You have " + x + " tries left to guess the correct location of the Hurkle!");
      System.out.println("Please input your guess, for the x variable and the y variable.");
      int a = scan.nextInt();
      int b = scan.nextInt();
      while ((a < 0 ) || (a > 10) || b > 10 || b < 0) {
        System.out.println("Please make a valid guess.");
        a = scan.nextInt();
        b = scan.nextInt();
      }
      if(makeGuess(a,b).equals("Found Hurkle")){
        System.out.println("You beat the game!");
        break;
      } else {
        grid[b][a] = makeGuess(a,b);
        if(x == 1){
          System.out.println("You didn't get it in 5 tries. The Hurkle was at " + hurkeLoc[0] + ", " + hurkeLoc[1] + ".");
        }
        System.out.println("You didn't get it. Try again!");
      }
      if(x == 1){
        for(int i = grid.length -1; i >= 0; i--){
      for(int j = 0; j < grid[0].length; j++){
        if(grid[i][j] == null){
          if(i == hurkeLoc[0] && j == hurkeLoc[1]){
            System.out.print("[HK]");
          }
          else{
            System.out.print("[  ]");
          }
          
        }
        else{
          System.out.print("[" + grid[i][j] + "]");
        };
        if(j == grid[0].length-1){
          System.out.println("");
        }
      }
    }
      }
      else{
        System.out.print(this);
      }
      
      x--;
    }
  }
  /*returns a string that shows the board as well as previously guessed locations and direction
  For a 10x10 grid with a false guess at (5,6) and a hurkle at (8,8)the board would look like this:
        9 [  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
        8 [  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
        7 [  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
        6 [  ][  ][  ][  ][  ][NW][  ][  ][  ][  ]
        5 [  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
        4 [  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
        3 [  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
        2 [  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
        1 [  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
        0 [  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
            0   1   2   3   4   5   6   7   8   9  */
  public String toString() {
    for(int i = grid.length - 1; i >= 0; i--){
      System.out.printf("%d ", i);
      for(int j = 0; j < grid[0].length; j++){
        if(grid[i][j] == null){
          System.out.print("[  ]");
        }
        else{
          System.out.print("[" + grid[i][j] + "]");
        };
        if(j == grid[0].length-1){
          System.out.println("");
        }
      }
    }
    System.out.print("   ");
    for (int i = 0; i < 10; i++) {
      System.out.printf(" %d  ", i);
    }
    System.out.println();
    return "";

  }  
}
