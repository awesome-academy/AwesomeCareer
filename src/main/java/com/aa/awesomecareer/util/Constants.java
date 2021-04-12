package com.aa.awesomecareer.util;

public class Constants {
	
	public enum Status {
		PENDING(1),ACTIVE(2),CLOSE(0);

		private int value;

		Status(int value) {
			this.value = value;
		}
		
		public static String getStatusByValue(int value) {
			for (Status s : Status.values()) {
				if (s.value == value) {
					return s.name();
				}
			}
			return null;
		}
		
	}

}
