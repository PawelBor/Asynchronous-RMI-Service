package ie.gmit.sw;

public class Task { //Keep form info + add Tasks
	//Instance variables
		private String taskNumber;
		private String algo;
		private String string1;
		private String string2;
		
		//Constructor
		public Task(String taskNumber, String algo, String str1, String str2){
			this.taskNumber = taskNumber;
			this.algo = algo;
			this.string1 = str1;
			this.string2 = str2;
		}
		//Getters and Setters
		public String getTaskNumber() {
			return taskNumber;
		}

		public void setTaskNumber(String taskNumber) {
			this.taskNumber = taskNumber;
		}

		public String getAlgo() {
			return algo;
		}

		public void setAlgo(String algo) {
			this.algo = algo;
		}

		public String getString1() {
			return string1;
		}

		public void setString1(String string1) {
			this.string1 = string1;
		}

		public String getString2() {
			return string2;
		}

		public void setString2(String string2) {
			this.string2 = string2;
		}
}
