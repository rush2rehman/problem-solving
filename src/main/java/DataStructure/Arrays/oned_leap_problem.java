package DataStructure.Arrays;
import java.util.Scanner;
/*
Let's play a game on an array! You're standing at index  of an -element array named . From some index (where ), you can perform one of the following moves:

Move Backward: If cell  exists and contains a , you can walk back to cell .
Move Forward:
If cell  contains a zero, you can walk to cell .
If cell  contains a zero, you can jump to cell .
If you're standing in cell  or the value of , you can walk or jump off the end of the array and win the game.
In other words, you can move from index  to index , , or  as long as the destination index is a cell containing a . If the destination index is greater than , you win the game.

Given  and , complete the function in the editor below so that it returns true if you can win the game (or false if you cannot).

Input Format

The first line contains an integer, , denoting the number of queries (i.e., function calls).
The  subsequent lines describe each query over two lines:

The first line contains two space-separated integers describing the respective values of  and .
The second line contains  space-separated binary integers (i.e., zeroes and ones) describing the respective values of .
Constraints

It is guaranteed that the value of  is always .
Output Format

Return true if you can win the game; otherwise, return false.

Sample Input

4
5 3
0 0 0 0 0
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
3 1
0 1 0
Sample Output

YES
YES
NO
NO
Explanation

We perform the following  queries:

For  and , we can walk and/or jump to the end of the array because every cell contains a . Because we can win, we return true.
For  and , we can walk to index  and then jump  units to the end of the array. Because we can win, we return true.
For  and , there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
For  and , there is no way for us to get past the one at index . Because we cannot win, we return false.
*/


public class oned_leap_problem {
  public static boolean canWin(int leap, int[] game) {

    return check(leap, game, 0);
  }

  public static boolean check(int leap, int[] game, int i)
  {
    if(i >= 0  )
    {
      if (i > game.length - 1)
        return true;
      if(game[i] != 1)
      {
        if (game[i] != 0)
          return false;
        if (game[i] == 0 && i == game.length - 1)
          return true;
        if (game[i] == 0)
        {
          game[i] = 1;
          return
              check(leap, game, i + 1 ) ||
                  check(leap, game,i - 1) ||
                  check(leap, game, i + leap);

        }
      }

    }


    return false;
  }



  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    while (q-- > 0) {
      int n = scan.nextInt();
      int leap = scan.nextInt();

      int[] game = new int[n];
      for (int i = 0; i < n; i++) {
        game[i] = scan.nextInt();
      }

      System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
    }
    scan.close();
  }
}