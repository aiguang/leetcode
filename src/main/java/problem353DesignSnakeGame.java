import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

 You are given a list of food's positions in x-y order. When a snake eats the food, its length and the game's score both increase by 1.

 Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

 When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

 Example:
 Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake snake = new Snake(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
public class problem353DesignSnakeGame {
  public static void main(String[] args){
//   ["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move"]
//    [[3,3,[[2,0],[0,0],[0,2],[0,1],[2,2],[0,1]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["L"],["D"],["R"],["U"]]
//    [null,0,1,1,1,1,2,2,2,2,3,4,4,4,4,-1]
    int width = 3;
    int height = 3;
    int[][] food = new int[6][2];
    food[0][0] = 2;
    food[0][1] = 0;
    food[1][0] = 0;
    food[1][1] = 0;

    food[2][0] = 0;
    food[2][1] = 2;
    food[3][0] = 0;
    food[3][1] = 1;

    food[4][0] = 2;
    food[4][1] = 2;
    food[5][0] = 0;
    food[5][1] = 1;
    SnakeGame game = new SnakeGame(width, height, food);
    System.out.print(game.move("D") + ",");
    System.out.print(game.move("D") + ",");
    System.out.print(game.move("R") + ",");
    System.out.print(game.move("U") + ",");
    System.out.print(game.move("U") + ",");
    System.out.print(game.move("L") + ",");
    System.out.print(game.move("D") + ",");
    System.out.print(game.move("R") + ",");
    System.out.print(game.move("R") + ",");
    System.out.print(game.move("U") + ",");

    System.out.print(game.move("L") + ",");
    System.out.print(game.move("L") + ",");
    System.out.print(game.move("D") + ",");
    System.out.print(game.move("R") + ",");
    System.out.print(game.move("U") + ",");
  }
}

class SnakeGame {

  class Square{
    int x;
    int y;
    Square(int row, int column){
      this.x = row;
      this.y = column;
    }
  }
  List<Square> list = new ArrayList<Square>();
  Queue<Square> foodQueue = new ArrayDeque<Square>();
  int width = 0;
  int height = 0;
  int eat = 0;

  /** Initialize your data structure here.
   @param width - screen width
   @param height - screen height
   @param food - A list of food positions
   E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
  public SnakeGame(int width, int height, int[][] food) {
    this.width = width;
    this.height = height;

    for(int i = 0; i < food.length;i++){
      Square square = new Square(food[i][0], food[i][1]);
      foodQueue.offer(square);
    }
    list.add(new Square(0,0));
  }

  /** Moves the snake.
   @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   @return The game's score after the move. Return -1 if game over.
   Game over when snake crosses the screen boundary or bites its body. */
//
//  ["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move"]
//      [[3,3,[[2,0],[0,0],[0,2],[2,2]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["D"]]
//  [null,0,1,1,1,1,2,2,2,2,3,3,-1]
//  [null,0,1,1,1,1,2,2,2,2,3,3,3]
  public int move(String direction) {
    Square curP = list.get(0);
    Square next = null;
    if(direction.equals("U")){
      next = new Square(curP.x - 1, curP.y);
      if(next.x < 0) return -1;
    }else if(direction.equals("L")){
      next = new Square(curP.x, curP.y - 1);
      if(next.y < 0) return -1;
    }else if(direction.equals("R")){
      next = new Square(curP.x, curP.y + 1);
      if(next.y > width - 1) return -1;
    }else {
      next = new Square(curP.x + 1, curP.y);
      if(next.x > height - 1) return -1;
    }
    if(!foodQueue.isEmpty() && hasFood(next)){
      list.add(0, next);
      eat++;
    }else{
      list.add(0, next);
      list.remove(list.size() - 1);
    }
    if(isCollision(next)) return -1;
    return eat;
  }
  private boolean hasFood(Square position){
    Square first = foodQueue.peek();
    if(position.x == first.x && position.y == first.y){
      foodQueue.poll();
      return true;
    }
    return false;
  }
  private boolean isCollision(Square position){
    if(list.size() < 2) return false;
    for(int i = 1; i < list.size();i++){
      Square tmp = list.get(i);
      if(tmp.x == position.x && tmp.y == position.y) return true;
    }
    return false;
  }

}

