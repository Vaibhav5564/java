import java.util.Scanner ;
public class Loop{
    Node head ;
    class Node{
        String data ;
        Node next ;
    
    
    Node(String data){
        this.data = data ;
        this.next = null ;
    }
}
void add(String data){
    Node newNode = new Node(data);
    if(head == null){
        head = newNode ;
        return ;
    }
    Node temp = head ;
    while(temp.next != null){
        temp = temp.next ;
    }
    temp.next = newNode ; 
}
boolean isLoop(){
    Node hare = head ;
    Node turtle = head ;
   
    while(hare != null && hare.next != null){
        if(hare == turtle){
            return false;
        }
        hare = hare.next.next ;
        turtle = turtle.next ;
    }
    return true ;
}
void print(){
    Node temp = head ;
    while(temp != null){
        System.out.print(temp.data+" ");
        temp= temp.next ;
    }
}
    public static void main(String args[]){
        Loop list = new Loop();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of the List");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=1 ; i<=n ; i++){
            System.out.println("Enter Data");
            String data = sc.nextLine();
            list.add(data);
        }
        if(list.isLoop()){
            System.out.println("Loop is Present");
        }
            else{
                System.out.println("loop is not present");
            }
            list.print();
        }
    }
