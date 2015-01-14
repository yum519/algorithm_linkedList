package linkedListExample;

public class List {

	Node firstNode = null;

	public void initialize(int num) {
		firstNode = new Node();
		firstNode.next = null;
		firstNode.data = num;
	}

	public void destroy() {

		Node destroyNode = firstNode;
		Node temp;

		while (destroyNode.next != null) {
			temp = destroyNode.next;
			destroyNode.next = null;
			destroyNode = temp;
		}
		firstNode = null;
	}

	public void push(Node prev, int data) {
		Node nextNode = new Node();

		if (prev.next == null) {
			nextNode.next = null;
			prev.next = nextNode;
			nextNode.data = data;
		} else {
			nextNode.next = prev.next;
			prev.next = nextNode;
			nextNode.data = data;
		}
	}

	public void pop(Node target) {
		Node compareNode = firstNode;
		Node temp = null;

		while (compareNode != null) {
			if (compareNode.equals(target)) {
				if (compareNode.equals(firstNode)) {
					firstNode = compareNode.next;
				}
				if (temp != null)
					temp.next = compareNode.next;
				compareNode.next = null;
				break;
			} else {
				temp = compareNode;
				compareNode = compareNode.next;
				// continue;
			}
		}
	}

	public void print() {
		List list = new List();

		list.initialize(1);
		list.printNow(list);

		list.push(list.firstNode, 2);
		list.printNow(list);

		list.push(list.firstNode.next, 4);
		list.printNow(list);

		list.push(list.firstNode, 3);
		list.printNow(list);

		list.push(list.firstNode.next.next, 6);
		list.printNow(list);

		list.pop(list.firstNode);
		list.printNow(list);

		list.pop(list.firstNode.next);
		list.printNow(list);
		
		list.pop(list.firstNode.next.next);
		list.printNow(list);
		
		list.push(list.firstNode, 7);
		list.printNow(list);

		list.destroy();
		list.printNow(list);

	}

	public void printNow(List list) {
		Node temp1 = list.firstNode;
		while (temp1 != null) {
			System.out.println(temp1.data);
			temp1 = temp1.next;
		}
		System.out.println();
	}

}
