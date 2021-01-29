import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.math.*;

import javafx.scene.layout.Border;

public class GameNim extends Game{
   
   
    int WinningScore = 10;
    int LosingScore = -10;
    int NeutralScore = 0;


    public GameNim(){
        currentState= new StateNim();
       
        
    }

    public boolean isWinState(State state){
        StateNim tstate=(StateNim) state;
        //player who left one
        if(tstate.remaining_coin==1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isStuckState(State state){
        if(isWinState(state)){
            return false;
        }

        StateNim tstate=(StateNim) state;

        for(int i=0;i<13;i++){
            if(tstate.board[i] == '1'){
                return false;
            }
        }

        return true;
    }

    

    public Set<State> getSuccessors(State state){
        if(isWinState(state) || isStuckState(state))
            return null;
            
        Set<State> successors = new HashSet<State>();
        StateNim tstate = (StateNim) state;
        
        char mark = 'O';
        //human
        if (tstate.player == 1){
            mark='x';
        } 
        
        StateNim successor_state;

        
        int cnt = 1;
        int index = 0;

        //array for the index of the computer remove
        int next[] = new int[13];
        next[0] = -1;
        
        //decided the index of the coin that computer remove
        //we here put all the remaining coins in the array
        for (int i = 0; i <=tstate.board.length-1;i++) {
            if(tstate.board[i]=='1'){
                next[index++]=i;
            }
        }
        
       
        Integer [] count_remove = new Integer[]{1,2,3};
        int a= (int) Math.floor(Math.random()*count_remove.length);
        Integer count_re = count_remove[a];
        //here we use the ramdom function to ensure it is random for computer choose
        //we only can move 1, 2 or 3 coins for each time, so while less then 3, we doing the mark.
        while (cnt <= count_re ) {
            successor_state = new StateNim(tstate);
            
            for (int i = 0; i <=cnt-1; i++) {
                int ramdom=(int) Math.floor(Math.random()*next.length);
                successor_state.board[next[ramdom]] = ' ';
                successor_state.remaining_coin -= 1;
                successor_state.player = (state.player == 0 ? 1 : 0);
            }

            successors.add(successor_state);
            successor_state.remove_coin = cnt;
            cnt++;
        }
        return successors;

    }


    public double eval(State state) 
    {   
    	if(isWinState(state)) {
    		//player who made last move
    		int previous_player = (state.player==0 ? 1 : 0);
    	
	    	if (previous_player==0) //computer wins
	            return WinningScore;
	    	else //human wins
	            return LosingScore;
    	}

        return NeutralScore;
    }
    

    public static void main(String[] args) throws Exception {

        System.out.println("Start the game. Each index repesent one coin, The coin is list in array,\ninput the INTEGER of index that you want to remove, Each index should split by a space \n ");
        System.out.println("NOTE: \n IF YOU ENTER THE INDEX THAT ALREADY MOVED, IT WILL DIRECTLY TO LOSE THE GAME");
        //needed to get human's move
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        GameNim game = new GameNim();
        Search search = new Search(game);
        int depth = 8;

        switch_the_player:
        while (true) {

            StateNim nextState = null;

            switch (game.currentState.player) {
                case 1: //Human           
                    System.out.print("Enter your *valid* move>");
                    String[] input_move = null;

                    enter:

                    do {
                        input_move = in.readLine().split(" ");
                        StateNim tstate = (StateNim) game.currentState;

                    } while (input_move[0].equals(" "));

                    nextState = new StateNim((StateNim) game.currentState);
                    nextState.player = 1;
                    nextState.remove_coin = input_move.length;
                    for (int i = 0; i < input_move.length; i++) {
                        if(nextState.board[Integer.parseInt(input_move[i]) - 1] =='1'){
                            nextState.board[Integer.parseInt(input_move[i]) - 1] = ' ';
                            nextState.remaining_coin -= 1;
                        }else{
                            System.out.println("Sorry, the number you have entered is not valid, you lose");
                            break switch_the_player;
                        }
                           
                        
                        
                    }
                    System.out.println("Human: \n"+nextState + "\n" + "Coins left:" + nextState.remaining_coin + "\n");
                   
                    break;

                case 0: //Computer

                    nextState = (StateNim) search.bestSuccessorState(depth);
                    nextState.player = 0;
                    System.out.println("Computer: ");
                    System.out.println(nextState + "\n" + "Coins left:" + nextState.remaining_coin + "\n");
                    break;
            }

            game.currentState = nextState;
            //change player
            game.currentState.player = (game.currentState.player == 0 ? 1 : 0);

            //Who wins?
            if (game.isWinState(game.currentState)) {

                if (game.currentState.player == 1) //i.e. last move was by the computer
                {
                    System.out.println("Computer wins!");
                } else {
                    System.out.println("You win!");
                }

                break;
            }

            if (game.isStuckState(game.currentState)) {
                System.out.println("Cat's game!");
                break;
            }
        }
    }
}

