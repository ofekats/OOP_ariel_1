package observer;

import java.util.ArrayList;

/**
 * describe the Observerable in Observer
 */
public class GroupAdmin implements Sender{
    private ArrayList<Member> members = new ArrayList<Member>();
    private UndoableStringBuilder un_st = new UndoableStringBuilder();

    /**
     * get fun - (shallow copy to members)
     * @return un_st of admin
     */
    public UndoableStringBuilder getUndoableStringBuilder()
    {
       return un_st;
    }

    //methods of Sender that we have to implement:

    /**
     * methods to register observers
     * @param obj
     */
    @Override
    public void register(Member obj)
    {
        if(!members.contains(obj))
            members.add(obj);
        //System.out.println(obj +" got registered!");
    }

    /**
     * methods to unregister observers
     * @param obj
     */
    @Override
    public void unregister(Member obj)
    {
        members.remove(obj);
        //System.out.println(obj +" got unregistered");
    }

    /**
     * Inserts the string into this character sequence.
     * @param offset
     * @param obj
     */
    @Override
    public void insert(int offset, String obj)
    {
        un_st.insert(offset,obj);
        notifyObservers();
    }

    /**
     * Appends the specified string to this character sequence.
     * @param obj
     */
    @Override
    public void append(String obj)
    {
        un_st.append(obj);
        notifyObservers();
    }

    /**
     * Removes the characters in a substring of this sequence.
     * @param start
     * @param end
     */
    @Override
    public void delete(int start, int end)
    {
        un_st.delete(start,end);
        notifyObservers();
    }

    /**
     * Erases the last change done to the document, reverting
     * it to an older state.
     */
    @Override
    public void undo()
    {
        un_st.undo();
        notifyObservers();
    }

    /**
     * after any change we notifyObservers()
     */
    public void notifyObservers() {
        for (Member member : members)
            member.update(un_st);
    }

    /**
     * return the size of the list of members
     * (used in tests)
     * @return
     */
    public int numOfMembers()
    {
        return members.size();
    }
}
