import java.util.ArrayList;
import java.util.Collections;

public class ImmutableFunction {

		public static final ArrayList<String> originalList = new ArrayList<String>() {{add("one"); add("two");add("three");}};
		public static final ArrayList<String> addList = new ArrayList<String>() {{add("one"); add("two");add("five");add("six");}}; 
		public static final ArrayList<String> deleteList = new ArrayList<String>() {{add("two");add("five");}}; 
		public static final ArrayList<String> ResultList = new ArrayList<String>(originalList.size() + addList.size() - deleteList.size());
		
		
		public static final void mergeList() {
			ResultList.addAll(originalList);
			
			int len = addList.size();
			int count = 0;
			while(count!=len) {
			if(!ResultList.contains(addList.get(count))) {
			
				ResultList.add(addList.get(count));
			}
			count++;
		}
			ResultList.removeAll(deleteList);
					
			for(int i=0; i<ResultList.size(); i++) {
				for(int y= i+1; y<ResultList.size(); y++) {
					 if(ResultList.get(i).length() < ResultList.get(i+1).length())
						 Collections.swap(ResultList,i,i+1);
					 else if(ResultList.get(i).length() == ResultList.get(i+1).length() && (ResultList.get(i).compareTo(ResultList.get(i+1)) < 0)) {
						 Collections.swap(ResultList,i,i+1);
					 }
				}
			}
			System.out.println("Result List : " + ResultList);
		}

		public static void main(String[] args) {
			mergeList();
		}

	}

