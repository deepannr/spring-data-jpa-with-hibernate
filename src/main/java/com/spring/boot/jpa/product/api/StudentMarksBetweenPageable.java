package com.spring.boot.jpa.product.api;

class StudentMarksBetweenPageable {
	private int fromMarks;
	
	private int toMarks;
	
	private int page;
	
	private int size;

	public StudentMarksBetweenPageable() {
		// Do Nothing
	}

	public StudentMarksBetweenPageable(int fromMarks, int toMarks, int page, int size) {
		this.fromMarks = fromMarks;
		this.toMarks = toMarks;
		this.page = page;
		this.size = size;
	}

	public int getFromMarks() {
		return fromMarks;
	}

	public void setFromMarks(int fromMarks) {
		this.fromMarks = fromMarks;
	}

	public int getToMarks() {
		return toMarks;
	}

	public void setToMarks(int toMarks) {
		this.toMarks = toMarks;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
