import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1};
        int[] arr2 = {1, 0, 1};
        final Polynom polynomial1 = new Polynom(arr1);
        final Polynom polynomial2 = new Polynom(arr2);
        float probability = (float) 0.5;



        NonSystematicCoder coder = new NonSystematicCoder(polynomial1, polynomial2);

        String sequence = "101";

        ArrayList<Integer> result = coder.encode(sequence);
        Channel channel = new Channel(probability);

        channel.setInputVector(result);
        channel.sendThroughChannel();

        System.out.println("After encode: " + result.toString());
        System.out.println("After send: " + channel.getOutputVector());
        System.out.println("There were " + channel.getErrorPositions().size() + " errors made in these positions: \n" +
                channel.getDisplayErrorPositions());

        Decoder decoder = new Decoder();
        decoder.setInputVector(channel.getOutputVector());
        decoder.decode();


        System.out.println("After decode: " + decoder.getOutputVector());
    }
}
