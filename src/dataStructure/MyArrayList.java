package dataStructure;

public class MyArrayList {
	
	// 변수1:  배열 
	private int[] data;
	// 변수2:  배열 요소의 길이
	private int size;
	
	// 생성자
	public MyArrayList(int capacity) {
		data = new int[capacity];
		size = 0;
	}
	
	// 메서드: 리사이징 
	public void resize() {
		int[] newData = new int[data.length * 2];
		if(data.length == size) {
			for(int i = 0; i < data.length; i++) {
				newData[i] = data[i];
				data[i] = 0;
			}
		}
		data = newData;
	}
	
	// 메서드: 배열 길이 얻기
	public int size() {
		return size;
	}
	
	// 메서드: 배열 끝 요소 추가
	public void add(int num) {
		if(data.length == size) {
			resize();
		}
		data[size++] = num;
	}
	
	// 메서드: 배열 끝 요소 제거
	public void removeLast() {
		if (size == 0) throw new IllegalStateException("No element to remove");
		size--;
	}
	
	// 메서드: 특정 인덱스의 값 가져오기
	public int get(int index) {
		if (index < 0 || index >= data.length) throw new ArrayIndexOutOfBoundsException();
		return data[index];
	}
	
	public static void main(String[] args) {
		MyArrayList arrLst = new MyArrayList(2);
		arrLst.add(10);
		arrLst.add(20);
		arrLst.add(30);
        System.out.println(arrLst.get(0)); // 10
        System.out.println(arrLst.get(2)); // 30
        arrLst.removeLast();
        System.out.println(arrLst.size()); // 2
	}
	
}
