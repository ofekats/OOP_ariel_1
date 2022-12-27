package observer;

public class Main {

    public static void main(String[] args)
    {
    GroupAdmin admin = new GroupAdmin();
    ConcreteMember member1 = new ConcreteMember("member1", admin);
    ConcreteMember member2 = new ConcreteMember("member2", admin);
    ConcreteMember member3 = new ConcreteMember("member3", admin);
    ConcreteMember member4 = new ConcreteMember("member4", admin);
    admin.register(member1);
    admin.register(member2);
    admin.register(member3);
    admin.register(member4);
    admin.append("welcome!!!");
    admin.insert(0, "!!!");

    admin.unregister(member4);
    admin.undo();




    }
}
