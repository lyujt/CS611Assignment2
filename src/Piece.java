import java.awt.*;

public class Piece {
    private final String type;

    // construct by type
    public Piece(String type){
        this.type = type;
    }

    // get piece type
    public String getType() {
        return type;
    }
}
