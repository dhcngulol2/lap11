package BaiTH11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}
	public void add(E data) {
        if (root == null) {
            root = new BNode<>(data);
        } else {
            root.add(data);
        }
    }
	public void add(Collection<E> col) {
		Iterator<E> st = col.iterator();
		while (st.hasNext()) {
			E element = st.next();
			root.add(element);
		}
		}
	public int depth(E node) {
		if(root == null) {
			return -1;
		}
		return root.findDept(node,0);
		
	
	}
	public int size() {
		
		return (root == null) ? 0 : root.count();
		}
	public boolean contains(E e) {
		if (root == null ) {
			return false ;
		}
		
		return root.contains(e);
		
		}
	public E findMin() {
		if (root == null ) {
			return null ;
		}
		return root.findMin();
	}
	public E findMax() {
		if (root == null ) {
			return null ;
		}
		return root.findMax();
	}
	public boolean remove(E e) {
		BNode<E> element = root.find(e);
		BNode<E> bo = root.findFather(e);
		if (root== null || element==null) {
			return false ;
		}
		
		bo.remove(element);
		
		
		return false;
	}
	public List<E> descendants(E e) {
		BNode<E> bo = root.find(e);
		if (root== null || bo==null) {
			return null ;
		}
		List<E> re = bo.descendants();
		return re;
	}
	public List<E> ancestors(E e) {
			BNode<E> con = root.find(e);
			if (root== null || con==null) {
				return null ;
			}
			
			
		return root.ancestors(e);
	}
	public void inorder() {
		List<E> list = new ArrayList<>();
        if (root != null) {
            root.inorder(list);
        }
        
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    
	}
	public void preorder() {
		List<E> list = new ArrayList<>();
        if (root != null) {
            root.preorder(list);
        }
        
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
	}
	public void postorder() {
		List<E> list = new ArrayList<>();
        if (root != null) {
            root.postorder(list);
        }
        
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
	}


	public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        
        // Thêm các nút vào cây
        tree.add(25);
        tree.add(15);
        tree.add(50);
        tree.add(10);
        tree.add(22);
        tree.add(35);
        tree.add(70);
        tree.add(4);
        tree.add(12);
        tree.add(18);
        tree.add(24);
        tree.add(70);
        tree.add(31);
        tree.add(44);
        tree.add(66);
        tree.add(90);
        
//        // In ra kích thước của cây
//        System.out.println("Kích thước của cây: " + tree.size());
//        
//        // Thêm một số nút khác và in lại kích thước
//        tree.add(20);
//        tree.add(12);
//        System.out.println("Kích thước sau khi thêm nút mới: " + tree.size());
//        System.out.println("Có tồn tại không "+ tree.contains(12));
//        System.out.println("Các con : " + tree.descendants(15));
        System.out.println("Duyệt cây theo thứ tự trung tố (inorder):");
        tree.inorder();
        System.out.println();
        System.out.println("Duyệt cây theo thứ tự trung tố (preorder):");
        tree.preorder();
        System.out.println();
        System.out.println("Duyệt cây theo thứ tự trung tố (postorder):");
        tree.postorder();
    }
	

}
