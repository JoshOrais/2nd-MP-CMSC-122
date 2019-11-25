public class Sorter{
	public Node[] mergeSort(Node[] arr){
		if (arr.length <= 1) {
			return arr;
		}
		
		int splitindex = arr.length / 2;
		Node[] lArr = mergeSort(split(arr, 0, splitindex));
		Node[] rArr = mergeSort(split(arr, splitindex, arr.length));

		return merge(lArr,rArr);
	}
		
	public Node[] merge(Node[] left, Node[] right){
		int lefti = 0;
		int righti = 0;
		Node[] ordered = new Node[left.length + right.length];
		int i = 0;
		
		while (lefti < left.length  && righti < right.length) {
			if (left[lefti].getValue() < right[righti].getValue()){
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