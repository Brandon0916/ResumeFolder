public class StateNim extends State {

    //set the initial board 
	int remaining_coin;
    public char board[] = new char [remaining_coin];

    //set the int of the remove coin
    int remove_coin;
    
    public StateNim() {
        remaining_coin=13;
        board=new char[remaining_coin];
        for (int i=0; i<13; i++) 
            board[i] =  ' ';
        
        player = 1;
        remove_coin=0;
    }
    
    public StateNim(StateNim state) {
        this.remaining_coin=state.remaining_coin;
        this.remove_coin=state.remove_coin; 
        this.board=new char[state.board.length];
        
        for(int i=0; i<13; i++)
            this.board[i] = state.board[i]; 
        
        player = state.player;
    }
    
    public String toString() {
    	
    	String ret = "";
       
    	for(int i=0; i<13; i++) {
            ret += board[i] + ", ";
    		
    	}
    	return ret;
    }
}
