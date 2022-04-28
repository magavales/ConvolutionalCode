import java.util.ArrayList;

public abstract class Coder {
    Polynom polynomial1 = new Polynom();
    Polynom polynomial2 = new Polynom();

    public abstract ArrayList encode(String sequence);


}
