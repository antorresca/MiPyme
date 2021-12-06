package mipyme;

class UserNode{
	public User user;
	public UserNode next;
	public UserNode prev;

	UserNode(User user){
		this.user = user;
        this.next=null;
        this.prev=null;
	}
}