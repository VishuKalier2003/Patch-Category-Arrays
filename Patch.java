/* Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the 
range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches 
required.
* Eg 1 : nums = [1,2]           n = 6                Output = 1  
* Eg 2 : nums = [1,5,10]        n = 20               Output = 2
* Eg 3 : nums = [1,2,2]         n = 5                Output = 0
*/
import java.util.*;
public class Patch
{
      public int MinimumRequiredPatches(int nums[], int n)
      {
            Map<Integer, Integer> RemainderMap = new HashMap<Integer, Integer>();   //* HasMap -> O(N)
            for(int i = 0; i < nums.length; i++)
                  RemainderMap.put(nums[i], i);    //! HaspMap Allocation -> O(N)
            int patches = 0;       //*   Variable -> O(1)
            for(int i = 1; i < n; i++)       //! Comparison -> O(N)
            {
                  if(n % i == 0)     // If divisible...
                  {
                        if(!RemainderMap.containsKey(i))    // But not present in Map...
                              patches++;
                  }
            }
            return patches;    // Returning the patches required...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter array length : ");
            x = sc.nextInt();
            int arr[] = new int[x];
            for(int i = 0; i < arr.length; i++)
            {
                  System.out.print("Enter data : ");
                  arr[i] = sc.nextInt();
            }
            System.out.print("Enter patch number : ");
            x = sc.nextInt();
            Patch patch = new Patch();
            System.out.println("The Minimum Patches required : "+patch.MinimumRequiredPatches(arr, x));
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(N)