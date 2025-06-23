import java.util.ArrayList;
public class four{
    //? Print all subsets
    public static void main(String[] args){
        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subsets(arr,ans);
        System.out.print(ans);
    }
    //* Approach : power set (ref image)
    public static void subsets(int[] arr,ArrayList<ArrayList<Integer>> ans){
        int n = arr.length;
        for(int num=0;num<(1<<n);num++){
            ArrayList<Integer> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num&(1<<i))!=0){
                    li.add(arr[i]);
                }
            }
            ans.add(new ArrayList<>(li));
        }
    }
}