package mycollections;

import java.util.*;

public class MergeSorted<E extends Comparable> {

	public List<E> merge(List<E> A, List<E> B) {
		if(A == null || A.size() == 0) {
			return B;
		}else if(B == null || B.size() == 0) {
			return A;
		}
		List<E> res = new ArrayList<>();
		int p1 = 0, p2 = 0;
		while (p1 < A.size() && p2 < B.size()) {
			if (A.get(p1).compareTo(B.get(p2)) <= 0)
				res.add(A.get(p1++));
			else
				res.add(B.get(p2++));
		}
		while(p1 < A.size())
			res.add(A.get(p1++));
		while(p2 < B.size())
			res.add(B.get(p2++));
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>(); //[1, 3]
		ArrayList<Integer> b = new ArrayList<>(); //[2, 4, 5]
		a.add(1);
		a.add(3);
		b.add(2);
		b.add(4);
		b.add(5);

		LinkedList<String> c = new LinkedList<>(); //[AA, FF]
		LinkedList<String> d = new LinkedList<>(); //[BB, CC, EE]
		c.add("AA");
		c.add("FF");
		d.add("BB");
		d.add("CC");
		d.add("EE");

		MergeSorted<Integer> test1 = new MergeSorted<>();
		List<Integer> res1 = test1.merge(a , b);
		for(int i : res1) {
			System.out.println(i);
		}

		MergeSorted<String> test2 = new MergeSorted<>();
		List<String> res2 = test2.merge(c, d);
		for(String i : res2) {
			System.out.println(i);
		}
	}

}
