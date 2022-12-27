package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender{
    private ArrayList<Member> members = new ArrayList<Member>();
    private UndoableStringBuilder un_st = new UndoableStringBuilder();

    //get
    public UndoableStringBuilder getUndoableStringBuilder()
    {
       return un_st;
    }

    //methods of Sender that we have to implement:
    //methods to register and unregister observers
    @Override
    public void register(Member obj)
    {
        members.add(obj);
        System.out.println(obj +" got registered!");
    }

    @Override
    public void unregister(Member obj)
    {
        members.remove(obj);
        System.out.println(obj +" got unregistered");
    }

    //Inserts the string into this character sequence.
    @Override
    public void insert(int offset, String obj)
    {
        un_st.insert(offset,obj);
        notifyObservers();
    }

    // Appends the specified string to this character sequence.
    @Override
    public void append(String obj)
    {
        un_st.append(obj);
        notifyObservers();
    }

    // Removes the characters in a substring of this sequence.
    @Override
    public void delete(int start, int end)
    {
        un_st.delete(start,end);
        notifyObservers();
    }

    // Erases the last change done to the document, reverting
    // it to an older state.
    @Override
    public void undo()
    {
        un_st.undo();
        notifyObservers();
    }

    //after any change
    public void notifyObservers() {
        for (Member member : members)
            member.update(un_st);
    }
}
