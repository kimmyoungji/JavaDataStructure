package array;

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
		if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
		return data[index];
	}
	
	// 메서드: 특정 인덱스에 요소 추가
	public void insert(int index, int num) {
		// 배열의 크기 확인
		// 배열에 빈공간이 없는 경우
		if( data.length == size) {
			// 리사이즈
			resize();
		// 배열에 빈공간이 있는 경우
		} else {
			// 진행
		}
			
		// 배열의 특정 인덱스 요소 부터 한 칸씩 뒤로 이동 시키기
		for(int i = index; i < data.length + 1; i++) {
			data[index + 1] = data[index];
		}
		// 배열의 특정 인덱스에 새로 들어온 값 할당하기
		data[index] = num;
	}
	
	// 메서드: 특정 인덱스의 요소 제거
	public void remove(int index) {
		// 배열이 빈 배열인지 확인
		// 빈 배열일 경우 // 배열 인덱스 경계 벗어남 에러
		if(size == 0) throw new IllegalStateException("No element to remove");
		// 빈 배열이 아닐 경우 // 특정 인덱스 위치의 값의 뒤에 값 부터 앞으로 한칸 씩 이동
		for(int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
		data[--size] = 0;
	}
	
	// 메서드: toString
	public String toString() {
		String result = "[";
		for(int i = 0; i < data.length; i++) {
			result += data[i];
			if(i != data.length - 1) {
				result += ", ";
			}
		}
		return result + "]";
	}
	
	public static void main(String[] args) {
		MyArrayList arrLst = new MyArrayList(2);
		arrLst.add(10);
		arrLst.add(20);
		arrLst.add(30);
		arrLst.remove(1);
		arrLst.insert(1, 100);
        System.out.println(arrLst.toString());
	}
	
}
