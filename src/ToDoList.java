/**
 * Created by aparnamahadevan on 16/2/17.
 */
import java.util.*;
import java.util.stream.Stream;
public class ToDoList{
    private LinkedList me = new LinkedList();

    public void adding(Scanner s) {
        System.out.println("What would you like to add? Type the task name");
        String task = s.nextLine();
        System.out.println("Please type your item description");
        String desc = s.nextLine();
        ListObject current = new ListObject(task, desc, false, false); //creates a todolist object
        me.add(current); //adds it to the list
    }

    public void removing(Scanner s){
        System.out.println("What would you like to remove? Type the item number");
        String task = s.nextLine();
        int taskNo = Integer.parseInt(task);
        taskNo--;
        me.remove(taskNo);
    }

    //problem: can only use inbuilt linkedlist class on objects - so e.g. cannot do remove(string). have to do remove(listobject)
    public void CMS(String stat,int num, Scanner s){
        System.out.println("Which item would you like to " + stat + "? Type the item number");
        String task = s.nextLine();
        int taskNo = Integer.parseInt(task);
        ListIterator l = me.listIterator(0);
        int i = 0;
        ListObject item = new ListObject();
        while (i < taskNo){
            item = (ListObject) l.next();
            i++;
        }

        if (num == 3){
            item.setChecked(true);
        }
        else if (num == 4){
            item.setChecked(false);
        }
        else {
            item.setPriority(true);
        }
    }

    public void search(Scanner s){
        System.out.println("Which item would you like to search for? Type a search word");
        String keyword = s.nextLine();
        ListIterator l = me.listIterator(0);
        System.out.println("Results:");
        while (l.hasNext()){
            ListObject o = (ListObject) l.next();
            if ((o.getData()).contains(keyword)){
                int j = me.indexOf(o);
                j++;
                System.out.println(j + ") " + o.getData());
            }
        }
    }

    public void display(){
        System.out.println("Your To Do List");
        ListIterator l = me.listIterator(0);
        while (l.hasNext()){
            ListObject o  = (ListObject) l.next();
            int j = me.indexOf(o);
            j++;
            System.out.print(j + ") " + o.getData());
            if (o.getPriority()) {
                System.out.print("***");
            }
            if (o.getChecked()){
                System.out.print("//");
            }
            System.out.println("   Description: " + o.getDescription());
        }
    }

    public void Performing(String event, Scanner s){
        int perform = Integer.parseInt(event);
        String stat = "";
        switch(perform) {
            case 1:
                adding(s); //add to end of list
                break;
            case 2:
                removing(s); //remove specific item
                break;
            case 3:
                CMS("check", 3, s);
                break;
            case 4:
                CMS("uncheck", 4, s);
                break;
            case 5:
                CMS("mark as priority", 5, s);
                break;
            case 6:
                search(s);
                break;
            default:
                System.out.println("Invalid input. Please try again");
                String s1 = s.nextLine();
                Performing(s1, s);
        }
        Runner(s);
    }

    public void Runner(Scanner s) {
        display();
        System.out.println("Choose a number from the options below: 1) add, 2) remove, 3) check, 4) uncheck, 5) mark as priority, 6) search for an item");
        while(s.hasNextLine()) {
            String event = s.nextLine();
            Performing(event, s);
        }
    }

    public static void main(String args[]) {
        ToDoList mylist = new ToDoList();
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to your To Do List!");
        mylist.Runner(s);
    }
}

