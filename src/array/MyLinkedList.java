package array;

public class MyLinkedList {

	MyNode head = null;
	MyNode tail = head;
	int size = 0;
	
	public class MyNode {
		int value;
		MyNode next;
		
		MyNode(int value, MyNode next) {
			this.value = value;
			this.next = next;
		}
	}
	
	// 메서드: 배열 끝 요소 추가
	public void add(int num) {
		// 들어온 값을 담은 새로운 노드 만들기
		MyNode newNode = new MyNode(num, null);
		
		// 만약 head 가 null 이라면
		if ( head == null ) {
			head = newNode;
			tail = newNode;
		// 만약 head 가 null이 아니라면
		} else {
			// 현재 tail이 가리키는 노드를 새로운 노드로 지정
			tail.next = newNode;
			// 새로운 노드를 tail로 지정
			tail = newNode;
		}
		
		// size + 1
		++size;
	}
	
	// 메서드: 배열 끝 요소 제거
	public void removeLast() {
		// 빈 배열인지 확인
		if (head == null) throw new IllegalStateException("this linkedlist is empty");
		
		// 노드가 1개 일때
		if (size == 1) {
			head = null;
			tail = null;
			size = 0;
			return;
		}
		
		// 빈배열이 아니고, 노드가 1개보다 많을 때
		// 다음 노드가 가리키는 노드가 없는 노드를 찾아서 
		MyNode curNode = head;
		while(true) {
			if(curNode.next.next == null) {
				break;
			}
			
			curNode = curNode.next;
		}
		
		// 찾은 노드의 next에 null을 할당
		curNode.next = null;
		
		// curNode를 tail로 지정
		tail = curNode;
		
		// size 감소
		--size;
	}
	
	// 메서드: 배열 문자열 변환
	public String toString() {
		
		// 결과 저장 변수
		String result = "[";
		
		// head 노드 부터 마지막 노드(next가 null)인 노드까지 순차적으로 결과 문자열에 추가
		MyNode curNode = head;
		while (curNode.next != null) {
			
			// 현재 선택된 노드의 값을 결과 문자열에 추가
			result += curNode.value;
			
			// ", " 추가
			result += ", "; 
			
			// 다음 노드를 선택하기
			curNode = curNode.next;
		}
		
		// 마지막 노드 추가해주기
		result += curNode.value;
		
		// 결과 반환
		return result + "]";
	}
	
	
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.add(2);
		myLinkedList.add(2);
		myLinkedList.removeLast();
		myLinkedList.removeLast();
		System.out.println(myLinkedList.toString());
	}

}
