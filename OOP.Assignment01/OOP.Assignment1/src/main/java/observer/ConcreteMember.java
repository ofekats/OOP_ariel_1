package observer;

/**
 * describe the Observer in Observer
 */
public class ConcreteMember implements Member{
    private String name;
    private GroupAdmin admin;
    private UndoableStringBuilder un_st_member = null;
    //private GroupAdmin admin;

    /**
     * constructor
     * @param name
     * @param admin
     */
    public ConcreteMember(String name, GroupAdmin admin)
    {
        this.name = name;
        this.admin = admin;
        //shallow copy
        //admin.getUndoableStringBuilder(un_st_member);
    }

    /**
     * implement necessary because implements Member
     * the member get update
     * @param usb
     */
    @Override
    public void update(UndoableStringBuilder usb)
    {
        //shallow copy
        un_st_member = admin.getUndoableStringBuilder();
        System.out.println("Member "+name+" get update to: "+ un_st_member);
    }

    /**
     * override ToString
     * @return name of member
     */
    @Override
    public String toString()
    {
       return this.name;
    }

    /**
     * get fun
     * @return pointer to un_st of admin
     */
    public UndoableStringBuilder getUn_st_member()
    {
        return un_st_member;
    }
}
