public class StaticVarExample{
    String myClassVar = "class or static variable";

    public static void main(String[] args) {
        StaticVarExample obj = new StaticVarExample();
        StaticVarExample obj2 = new StaticVarExample();
        StaticVarExample obj3 = new StaticVarExample();
        // StaticVarExample obj = new StaticVarExample();

        System.out.println(obj.myClassVar);
        System.out.println(obj2.myClassVar);        
        System.out.println(obj3.myClassVar);
        // System.out.println(obj.myClassVar);

        obj2.myClassVar = "Changed Text";
        
        System.out.println(obj.myClassVar);        
        System.out.println(obj2.myClassVar);
        System.out.println(obj3.myClassVar);
    }
}