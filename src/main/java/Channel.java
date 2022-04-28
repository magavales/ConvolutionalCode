import java.util.ArrayList;
import java.util.Collections;

public class Channel {

    private final float probability;
    private boolean isZero;

    private ArrayList<Integer> inputVector = new ArrayList<Integer>();
    private ArrayList<Integer> outputVector = new ArrayList<Integer>();
    private ArrayList<Integer> errorPositions = new ArrayList<Integer>();


    public Channel(float probability) {
        this.probability = probability;
    }

    public void setInputVector(ArrayList<Integer> inputVector) {
        this.inputVector = inputVector;
    }
    public ArrayList<Integer> getOutputVector() {
        return outputVector;
    }

    public ArrayList<Integer> getErrorPositions() {
        return errorPositions;
    }

    public ArrayList<Integer> getDisplayErrorPositions(){           // sorts the given ArrayList of errors and prepares it for display (starts from 1 and not from 0).
        ArrayList<Integer> errorPositionsTemp = new ArrayList<>();
        for (int i : errorPositions){
            errorPositionsTemp.add(i + 1);
        }
        Collections.sort(errorPositionsTemp);
        return errorPositionsTemp;
    }

    public void sendThroughChannel(){           // makes errors in inputVector with the given probability and returns it in outputVector
        outputVector.clear();
        errorPositions.clear();
        for (int i = 0; i < inputVector.size(); i++) {
            if (Math.random() <= probability)
            {
                if (inputVector.get(i) == 1)
                    outputVector.add(0);
                else
                    outputVector.add(1);
                errorPositions.add(i);
            }
            else
                outputVector.add(inputVector.get(i));
        }
    }

    public void changeBit(int position){        // changes a bit at the given position in the outputVector. Updates errorPositions array as well.
        if (position < outputVector.size() && position >= 0){
            if(outputVector.get(position) == 0)
                outputVector.set(position, 1);
            else
                outputVector.set(position, 0);

            if(errorPositions.contains(position)){  // change errorPositions depending on whether we are adding an error or fixing one
                errorPositions.remove((Object) position);
            }
            else
                errorPositions.add(position);
        }
    }
}