package mipyme;

public class Users{
    UserNode head;
    UserNode tail;
    int id=0;
    public Users(){
        this.head=null;
        this.tail=null;
    }
    public void addUser(String userName, String pasword){
        User newUser = new User(++this.id, userName, pasword);
        UserNode newUserNode = new UserNode(newUser);
        
        if (this.head == null){
            this.head = newUserNode;
            this.tail = this.head;
        }else{
            if(this.head.next==null){
                this.tail = this.head;
            }
            this.tail.next = newUserNode;
            newUserNode.prev = this.tail;
            this.tail = this.tail.next;        
        } 
    }
    
    public User delLastUser(){
        	if (this.head == null){
                System.exit(1);
                return null;
        	}else{ 
            User deletedUser = this.tail.user;
            if(this.head == this.tail){
                this.tail = null;
                this.head = null;
            }else{
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
            return deletedUser;
            }
    }
    
    public User delFirstUser(){
        
        if (this.head == null){
            System.exit(1);
             return null;
        }else{
            User deletedUser = this.head.user;
            
            if(this.head == this.tail){
                this.tail = null;
                this.head = null;
            }else if(this.head.next!=null){
                this.head = this.head.next;
                this.head.prev = null;
            }
          return deletedUser;
        }
	
  }
    
    public UserNode findById(int id){
        UserNode copy = this.head;
        while(copy!=null){
            if(copy.user.id == id){
                return copy;
            }
            copy = copy.next;
        }
        return null;
    }
    
    public boolean userNameTaken(String userName){
        UserNode copy = this.head;
        while(copy!=null){
            if(copy.user.userName == userName){
                return true;
            }
            copy = copy.next;
        }
        return false;
    }
    
    public void delUserById(int id){
        UserNode temp = this.findById(id);
        if(temp.prev!=null){
            if(temp.next!=null){
        		temp.prev = temp.next; 
            	temp = null;
            }else{
                delLastUser();
            }
        }else{
            delFirstUser();
        }
    }
}