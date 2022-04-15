package BeautySalon;

public class Customer {
	
	private String name;
	private boolean isMember = false;
	private String memberType;

	Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "Customer [Name=" + name + ", Member Status = " + isMember + ", Member Type = " + memberType + "]";
	}
}
