package multithreading.assignment.ass6.q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Process implements Runnable{
	List<Integer> list = new ArrayList<>();

	Process(List<Integer> list){
		this.list = list;
	}
	@Override
	public void run() {
		Collections.sort(list);
	}

}
