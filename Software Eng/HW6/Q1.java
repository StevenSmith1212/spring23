import java.util.List;
import java.util.Set;

public class Q1{
//Association
class Store{
    private String name;

    private Set<Employee> employees; 
    //constructor
    Store(String name){
        this.name = name; 
    }

    //getName Method
    public String getName(){
        return this.name;
    }

    public void setEmployees(Set<Employee> employees){
        this.employees = employees;
    }
  public  Set<Q1.Employee> getEmployees(Set<Employee> employees){
        return this.employees;
    }

}

class Employee{
    private String name;


    Employee(String name){
        this.name = name;
    }

    public String getEmployeeName(){
        return this.name; 
    }

}


//Aggregation
class Club{
    private String name;
    private List<Member> members;
    Club(String name, List<Member> members){
        this.name = name; 
        //another class is necessart for the constructor of the other class.
        this.members = members; 
    }
}

class Member{
    private String name;
    private int ID;

    Member(String name, int ID){
        this.name = name;
        this.ID = ID;
    }
}

//Composition
class Car{
    private List<Parts> Parts;
   
    Car(List<Parts> Parts){
       this.Parts = Parts; 
    }
   
   }
   
   class Parts{
       private String PartID;

   
       Parts(String PartID){
           this.PartID = PartID;
       }
   
       public String getID(){
           return this.PartID;
       }
   }
}