package BaiTH11;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;
	public BNode(E data) {
	this.data = data;
	this.left = null;
	this.right = null;
	}
	public BNode(E data, BNode<E> left, BNode<E> right) {
	this.data = data;
	this.left = left;
	this.right = right;
	}
	public void add(E data2) {
		if(data2.compareTo(this.data)==-1) {
			if (left == null ) {
				left = new BNode<E>(data2);
			}else {
				left.add(data2);
			}
		}
		if(data2.compareTo(this.data)==1) {
			if (right == null ) {
				right = new BNode<E>(data2);
			}else {
				right.add(data2);
			}
		} 
		
		
	}
	public int findDept( E node, int i) {
		if(node == null ) {
			return -1;
		}
		if (node.compareTo(this.data)!=1) {
			return left.findDept(node, i+1);
		}
		if (node.compareTo(this.data)==1) {
			return left.findDept(node, i+1);
		}
		return i;
	}
	public int count() {
	    int leftCount = (left == null) ? 0 : left.count();
	    int rightCount = (right == null) ? 0 : right.count();
	    return 1 + leftCount + rightCount;
	}
	public boolean contains(E e) {
		if (e.compareTo(this.data)==-1) {
			return left.contains(e);
		}
		if (e.compareTo(this.data)==1) {
			return right.contains(e);
		}
		return true;
	}
	public E findMin() {
		if (left == null) {
			return data;
		}
		return left.findMin();
	}
	public E findMax() {
		if (right == null) {
			return data;
		}
		return right.findMax();
	}
	
	public boolean remove(BNode<E> e) {
		BNode<E> element = whichSide(e);
		if (element.whichType()==0) {
			element=null;
			return true;
		}
		if (element.whichType()==1) {
			if (element == left ) {
				left = e.noNull();
				e = null;
				return true;
			}
			if (element == right ) {
				right = e.noNull();
				e=null;
				return false;
			}
		}
		if(element.whichType()==2) {
			findMin2(element.right).left = element.left  ;
			BNode<E> temp = element.right;
			element = null;
			element = temp;
			return true;
			
		}
		return false;
	}
	private BNode<E> noNull() {
		return (left == null) ? right : left;
	}
	private BNode<E> whichSide(BNode<E> e) {
		return (left.data == e.data) ? left : right;
	}
	public int  whichType() {
		if (left == null && right == null) {
			return 0;
		}
		if (left != null && right == null && left == null && right != null ) {
			return 1;
		}
		
		return 2;
		
	}
	public BNode<E> find(E e) {
		if (e.compareTo(this.data)==-1) {
			return left.find(e);
		}
		if (e.compareTo(this.data)==1) {
			return right.find(e);
		}
		if (e.compareTo(this.data)==0) {
			return this;
		}
		
		return null;
	}
	public BNode<E> findFather(E e) {
		if (e.compareTo(left.data)==-1) {
			return left.findFather(e);
		}
		if (e.compareTo(right.data)==1) {
			return right.findFather(e);
		}
		return this ;
	}
	public BNode<E> findMin2(BNode<E> e) {
		if (left == null) {
			return e;
		}
		return e.findMin2(e);
	}
	public List<E> descendants(){
		List<E> list = new ArrayList<E>(); 
		if (left != null) {
			list.add(left.data);
			left.descendants();
		}
		if (right != null) {
			list.add(right.data);
			right.descendants();
		}
		return list;
	}
	public List<E> ancestors(E e) {
		List<E> list = new ArrayList<E>(); 
		if (e.compareTo(left.data)==-1) {
			list.add(left.data);
		}
		if (e.compareTo(right.data)==1) {
			list.add(right.data);
		}
		
		return list;
	}
	public void inorder(List<E> list) {
		
		if (left != null) {
			left.inorder(list);
		}
		list.add(data);
		if (right != null) {
			right.inorder(list);
			
		}
		
	}
	public void preorder(List<E> list) {
		list.add(data);
		if (left != null) {
			left.preorder(list);
		}
		if (right != null) {
			right.preorder(list);
		}
	}
	public void postorder(List<E> list) {
		if (left != null) {
			left.postorder(list);
		}
		if (right != null) {
			right.postorder(list);
		}	
		
		
		list.add(data);
	}
	
	
	

}
