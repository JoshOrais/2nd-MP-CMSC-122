public class MergeSort{
    private int item1;
    private int item2;

	public Node[] mergeSort(Node[] arr, String flag){
		if (arr.length <= 1) {
			return arr;
		}
		
		int splitindex = arr.length / 2;
		Node[] lArr = mergeSort(split(arr, 0, splitindex), flag);
		Node[] rArr = mergeSort(split(arr, splitindex, arr.length), flag);

		return merge(lArr,rArr, flag);
	}
		
	public Node[] merge(Node[] left, Node[] right, String flag){
		int lefti = 0;
		int righti = 0;
		Node[] ordered = new Node[left.length + right.length];
		int i = 0;
		
		while (lefti < left.length  && righti < right.length) {
            if(flag.equals("value")){
                item1 = left[lefti].getValue();
                item2 = right[righti].getValue();
            }
            else if(flag.equals("pixel")){
                item1 = left[lefti].getKey();
                item2 = right[righti].getKey();
            }

			if (item1 < item2){
				ordered[i] = left[lefti];
				lefti++;
			}
			else {
				ordered[i] = right[righti];
				righti++;
			}
			i++;
		}
		
		for (; lefti < left.length; ++lefti){
			ordered[i] = left[lefti];
			++i;
		}
		for (; righti < right.length; ++righti){
			ordered[i] = right[righti];
			++i;
		}
		return ordered;
	}

	public Node[] split(Node[] arr, int lo, int hi){
		Node[] nArr = new Node[hi-lo];
		for (int i = lo; i < hi; ++i){
			nArr[i - lo] = arr[i];
		}
		
		return nArr;
	}
}