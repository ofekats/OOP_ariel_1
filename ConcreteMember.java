package observer;

public class ConcreteMember implements Member{
    private String name;
    private GroupAdmin admin;
    private UndoableStringBuilder un_st_member = new UndoableStringBuilder();;
    //private GroupAdmin admin;

    public ConcreteMember(String name, GroupAdmin admin)
    {
        this.name = name;
        this.admin = admin;
        //sallow copy
        //admin.getUndoableStringBuilder(un_st_member);
    }

    //the member get update
    @Override
    public void update(UndoableStringBuilder usb)
    {
        //sallow copy
        un_st_member = admin.getUndoableStringBuilder();
        System.out.println("Member "+name+" get update to: "+ un_st_member);
    }

    @Override
    public String toString()
    {
       return this.name;
    }
}
