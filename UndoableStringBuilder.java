package observer;

import java.util.Stack;

public class UndoableStringBuilder
{
    private StringBuilder st;
    private Stack<String> stack;


    /**
     * empty constructor
     */
    public UndoableStringBuilder()
    {
        st = new StringBuilder("");
        stack = new Stack<String>();
    }

    /**
     * Appends the specified string to this character sequence.
     * @param str -String
     * @return st -StringBuilder
     */
    public UndoableStringBuilder append(String str)
    {
        stack.push(st.toString());
        st.append(str);
        return this;
    }

    /**
     * Removes the characters in a substring of this sequence.
     * @param start -int
     * @param end -int
     * @return st -StringBuilder
     */
    public UndoableStringBuilder delete(int start, int end)
    {
        try {
            stack.push(st.toString());
            st.delete(start, end);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return this;
    }

    /**
     * Inserts the string into this character sequence.
     * @param offset -int
     * @param str -String
     * @return st -StringBuilder
     */
    public UndoableStringBuilder insert(int offset, String str)
    {
        try
        {
            stack.push(st.toString());
            st.insert(offset, str);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String.
     * @param start -int
     * @param end -int
     * @param str -String
     * @return st -StringBuilder
     */
    public UndoableStringBuilder replace(int start,int end, String str)
    {
        try
        {
            stack.push(st.toString());
            st.replace(start, end, str);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     * @return st -StringBuilder
     */
    public UndoableStringBuilder reverse()
    {
        stack.push(st.toString());
        st.reverse();
        return this;
    }

    /**
     * undo the last action
     */
    public void undo()
    {
        try
        {
            st.setLength(0);
            st.append(stack.pop());
        }
        catch (Exception e)
        {}
    }

    /**
     * Override of toString()
     * @return st -String
     */
    @Override
    public String toString()
    {
        return st.toString();
    }
}
