public class BinarySearch{
    public String binSearch(int val, Node[] pathArr){
        int first = 0;
        int last = pathArr.length-1;
        int mid = (first+last)/2;
        String path = "";

        while(first <= last){
            if(pathArr[mid].getKey() < val){
                first = mid + 1;
            }
            else if(pathArr[mid].getKey() == val){
                path = pathArr[mid].getPath();
                break;
            }
            else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if(first > last){
            System.out.println("Not Found!");
        }

        return path;
    }

    public static void binarySearch(int arr[], int first, int last, int key){  
        int mid = (first + last)/2;  
        while( first <= last ){  
           if ( arr[mid] < key ){  
             first = mid + 1;     
           }else if ( arr[mid] == key ){  
             System.out.println("Element is found at index: " + mid);  
             break;  
           }else{  
              last = mid - 1;  
           }  
           mid = (first + last)/2;  
        }  
        if ( first > last ){  
           System.out.println("Element is not found!");  
        }  
      }  
}