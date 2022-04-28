import java.util.ArrayList;

public class NonSystematicCoder extends Coder {

    public NonSystematicCoder(Polynom polynomial1, Polynom polynomial2){
        this.polynomial1 = new Polynom(polynomial1);
        this.polynomial2 = new Polynom(polynomial2);
    }

    @Override
    public ArrayList<Integer> encode(String sequence) {
        int[] sq = new int[sequence.length()];
        int k = 0;
        for (char t : sequence.toCharArray()){
            sq[k] = Character.getNumericValue(t);
            k++;
        }

        Polynom m = new Polynom(sq);
        Polynom u1 = m.mul(polynomial1);
        Polynom u2 = m.mul(polynomial2);

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < u1.gettdeg() + 1; i++){
            u1.getArray()[i] = u1.getArray()[i] % 2;
            arr1.add(u1.getArray()[i]);
        }
        for (int i = 0; i < u2.gettdeg() + 1; i++){
            u2.getArray()[i] = u2.getArray()[i] % 2;
            arr2.add(u2.getArray()[i]);
        }


        if (arr1.size() > arr2.size()){
            for (int i = 0; i < arr1.size() - arr2.size(); i++){
                arr1.add(0);
            }
        }
        else {
            for (int i = 0; i < arr2.size() - arr1.size(); i++){
                arr2.add(0);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr1.size(); i++){
            result.add(arr1.get(i));
            result.add(arr2.get(i));
        }

        return result;
    }
}
