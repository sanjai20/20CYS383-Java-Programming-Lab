package Arraylist;
import java.util.ArrayList;
import java.util.Collections;

public class BasicsofArraylist {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Boolean> list2 = new ArrayList<>();
         /* int n=10;
        // ADD function

        for(int i=0;i<10;i++){
            list.add(i+1);
        }
        System.out.println(list);

        //GET function

        System.out.println((list.get(6)));

        //Remove function

        list.remove(3);
        System.out.println(list);

        //SET function

        list.set(5,29);
        System.out.println(list);
        
        //Contains Functions

        System.out.println(list.contains(8));
        System.out.println(list.contains(7));

        //Size funtion
        System.out.println(list.size());
        

        //Print Reverse of an ArrayList
        for(int i=0;i<5;i++){
            list1.add(i+1);
        }
        for(int i=list1.size()-1;i>=0;i--){
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();
        */

       //Print Maximum of an ArrayList
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);
        System.out.println(list);
        // int max = Integer.MIN_VALUE;
        // for(int i=0;i<list.size();i++){
        //     max = Math.max(max , list.get(i));
        // }
        // System.out.println(max);

        // swapping 
        // int idx1 = 1, idx2 =3;
        // swap(list, idx1, idx2);
        // System.out.println(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list , Collections.reverseOrder());
        System.out.println(list);


    }
    public static void swap(ArrayList<Integer> list, int idx1 , int idx2){
    int temp = list.get(idx1);
     list.set(idx1 , list.get(idx2));
     list.set(idx2,temp);
    }
}
