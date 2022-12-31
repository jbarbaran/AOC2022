package DayTwo;



public class Round {

    public enum RockPaperScissorOpponent{
        A, //Rock
        B, //Paper
        C  //Scissors
    }
    
    public enum RockPaperScissorResponse{
        X, //Rock
        Y, //Paper
        Z  //Scissors
    }

    public enum RockPaperScissor{
        ROCK,
        PAPER,
        SCISSORS
    }

    public enum ResultRound{
        WIN,
        LOSE,
        DRAW
    }

    private RockPaperScissor opponentMove;
    private RockPaperScissor selfResponse;

    private ResultRound expectedResult;

    public Round(char opponentMove, char selfResponse)
    {
        switch ( opponentMove)
        {
            case 'A':
                this.opponentMove = RockPaperScissor.ROCK;    
                break;
            case 'B':
                this.opponentMove = RockPaperScissor.PAPER;    
                break;
            case 'C':
                this.opponentMove = RockPaperScissor.SCISSORS;    
                break;
        }
        switch ( selfResponse)
        {
            case 'X':
                this.selfResponse = RockPaperScissor.ROCK;    
                break;
            case 'Y':
                this.selfResponse = RockPaperScissor.PAPER;    
                break;
            case 'Z':
                this.selfResponse = RockPaperScissor.SCISSORS;    
                break;
        }
    }

    public Round(char opponentMove, char expectedResult, Boolean partTwo)
    {
        switch ( opponentMove)
        {
            case 'A':
                this.opponentMove = RockPaperScissor.ROCK;    
                break;
            case 'B':
                this.opponentMove = RockPaperScissor.PAPER;    
                break;
            case 'C':
                this.opponentMove = RockPaperScissor.SCISSORS;    
                break;
        }
        switch ( expectedResult)
        {
            case 'X':
                this.expectedResult = ResultRound.LOSE;    
                break;
            case 'Y':
                this.expectedResult = ResultRound.DRAW;    
                break;
            case 'Z':
                this.expectedResult = ResultRound.WIN;    
                break;
        }
    }

    public int CalculatePoints()
    {
        ResultRound result = CalculateRoundResult();

        return CalculateShapePoints(selfResponse) + CalculateResultPoints(result);
        
    }

    public int CalculatePoints(Boolean partTwo)
    {

        RockPaperScissor movement = CalculateMovement();

        return CalculateShapePoints(movement) + CalculateResultPoints(expectedResult);
        
    }

    private int CalculateResultPoints(ResultRound result) {
        switch (result)
        {
            case LOSE:
                return 0;
            case DRAW:
                return 3;
            case WIN:
                return 6;
        }

        return 0;
    }

    private int CalculateShapePoints(RockPaperScissor shape) {
        if (shape == RockPaperScissor.ROCK)
        {
            return 1;
        }

        if (shape == RockPaperScissor.PAPER)
        {
            return 2;
        }

        if (shape == RockPaperScissor.SCISSORS)
        {
            return 3;
        }
        return 0;
    }

    private RockPaperScissor CalculateMovement()
    {

        if (expectedResult == ResultRound.WIN)
        {
            if (opponentMove == RockPaperScissor.ROCK)
            {
                return RockPaperScissor.PAPER;
            }
            if (opponentMove == RockPaperScissor.PAPER)
            {
                return RockPaperScissor.SCISSORS;
            }
            if (opponentMove == RockPaperScissor.SCISSORS)
            {
                return RockPaperScissor.ROCK;
            } 
        }

        if (expectedResult == ResultRound.DRAW)
        {
            return opponentMove;
        }

        if (expectedResult == ResultRound.LOSE)
        {
            if (opponentMove == RockPaperScissor.ROCK)
            {
                return RockPaperScissor.SCISSORS;
            }
            if (opponentMove == RockPaperScissor.PAPER)
            {
                return RockPaperScissor.ROCK;
            }
            if (opponentMove == RockPaperScissor.SCISSORS)
            {
                return RockPaperScissor.PAPER;
            } 
        }

        return RockPaperScissor.ROCK;
    }

    private ResultRound CalculateRoundResult() {

        ResultRound result = ResultRound.DRAW;
        if ( opponentMove == RockPaperScissor.ROCK) 
        {
            if ( selfResponse == RockPaperScissor.ROCK) //Rock vs Rock
            {
                return ResultRound.DRAW;
            }
            else if (selfResponse == RockPaperScissor.PAPER) //Rock vs Paper
            {
                return ResultRound.WIN;
            }
            else if (selfResponse == RockPaperScissor.SCISSORS) // Rock vs Scissors
            {
                return ResultRound.LOSE;
            }
        }

        if ( opponentMove == RockPaperScissor.PAPER) 
        {
            if ( selfResponse == RockPaperScissor.ROCK) //Paper vs Rock
            {
                return ResultRound.LOSE;
            }
            else if (selfResponse == RockPaperScissor.PAPER) //Paper vs Paper
            {
                return ResultRound.DRAW;
            }
            else if (selfResponse == RockPaperScissor.SCISSORS) // Paper vs Scissors
            {
                return ResultRound.WIN;
            }
        }

        if ( opponentMove == RockPaperScissor.SCISSORS) 
        {
            if ( selfResponse == RockPaperScissor.ROCK) //Scissors vs Rock
            {
                return ResultRound.WIN;
            }
            else if (selfResponse == RockPaperScissor.PAPER) //Scissors vs Paper
            {
                return ResultRound.LOSE;
            }
            else if (selfResponse == RockPaperScissor.SCISSORS) // Scissors vs Scissors
            {
                return ResultRound.DRAW;
            }
        }
        return result;
    }

}
