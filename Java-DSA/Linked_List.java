import java.util.Scanner ;
public class Linked_List{
 Node head ;
 
    class Node {
        String data ;
        Node next ;
    
    
    Node(String data){
        this.data = data ;
        this.next = null ;
    }
}
public void add_First(String data){
    Node newNode = new Node(data);
    if(head==null){
        head = newNode ;
        return ;
    }
    newNode.next = head ;
    head = newNode ;
    return ;
}
public void add_Last(String data){
    Node newNode = new Node(data);
    if(head == null){
        head=newNode;
        return ;
    }
    Node temp = head ;
    while(temp.next != null){
        temp=temp.next;
    }
    temp.next = newNode ;
    return ;
}
public void delete_First(){
    if(head == null){
        System.out.println("String is Empty");
    }
    if(head.next == null){
        head=null;
        return ;
    }
    head = head.next ; 
    return ;
}
public void delete_Last(){
   if(head == null){
        System.out.println("String is Empty");
    } 
    if(head.next == null){
        head=null;
    }
    Node temp = head ;
    Node temp2 = head.next ;
    while(temp2.next != null){
        temp2 = temp2.next ;
        temp = temp.next ;
    }
    temp.next = null ;
}
public int size(){
    int i = 0 ;
    Node temp = head ;
    while(temp != null)
    {
      i++;
      temp = temp.next ;
    }
    return i ;
}
public void add_Middle(String data , int pos){
    Node newNode = new Node(data); 
    Node temp = head ;
    if(pos == 0){
        add_First(data);
        return ;
    }
    if(pos == size()){
        add_Last(data);
    }
    for(int i=1 ; i<pos ; i++){
        temp=temp.next ;
    }
    newNode.next=temp.next ;
    temp.next = newNode ;
    return ;
}
public void delete_Middle(int pos){
    if(pos < 0 || pos>=size()){
        System.out.println("Invalid Index");
        return ;
    }
    Node temp = head ;
    if(pos == 0){
        delete_First();
        return ;
    }
    if(pos == size()){
        delete_Last();
    }
    for(int i=1 ; i<pos ; i++){
        temp = temp.next ;
    }
    Node temp2 = temp.next ;
    temp.next = temp2.next ;
    return ;
}
public void print(){
    Node temp = head ;
    while(temp != null){
        System.out.print(temp.data+"->");
        temp=temp.next ;
    }
    System.out.println("NULL");
}

public static void main(String args[]){
 Scanner sc = new Scanner(System.in);
 Linked_List list = new Linked_List() ;
 while(true){
     System.out.println("1. Add at First");
     System.out.println("2. Delete First");
     System.out.println("3. Add at Last");
     System.out.println("4. Delete from Last");
     System.out.println("5. Add at Any Position");
     System.out.println("6. Delete from any Position");
     System.out.println("7. Print a List");
     System.out.println();
     System.out.println("Enter Choice");
     int choice = sc.nextInt();
     sc.nextLine();
     switch(choice){
        
         case 1 :
             System.out.println("Enter String");
             String str = sc.nextLine();
             list.add_First(str);
             break ;
        
        case 2 :
             list.delete_First();
             break ;
        
        case 3 :
             String str2 = sc.nextLine();
             list.add_Last(str2);
             break ;
        
        case 4 :
             
             list.delete_Last();
             break ;
             
        case 5 :
             System.out.println("Enter String and Position");
             String str1 = sc.nextLine();
             int Pos = sc.nextInt();
             list.add_Middle(str1,Pos);
             break ;
        
        case 6 :
             System.out.println("Position");
             int Pos1 = sc.nextInt();
             list.delete_Middle(Pos1);
             break ;

         case 7 :
             list.print();
             break ;
        
        default :
            System.out.println("Invalid Choice ");
     }
 }
}
}