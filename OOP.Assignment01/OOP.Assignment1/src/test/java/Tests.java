import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void part_A_test()
    {
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("member1", admin);
        ConcreteMember member2 = new ConcreteMember("member2", admin);
        ConcreteMember member3 = new ConcreteMember("member3", admin);
        ConcreteMember member4 = new ConcreteMember("member4", admin);
        //add new member to the admin list
        admin.register(member1);
        admin.register(member2);
        admin.register(member3);
        admin.register(member4);

        //admin change the UndoableStringBuilder and we check if update really happened
        admin.append("welcome!!!");
        assertEquals(member1.getUn_st_member(),admin.getUndoableStringBuilder());
        assertEquals(member2.getUn_st_member(),admin.getUndoableStringBuilder());
        assertEquals(member3.getUn_st_member(),admin.getUndoableStringBuilder());
        assertEquals(member4.getUn_st_member(),admin.getUndoableStringBuilder());
        //unregister member4
        admin.unregister(member4);
        //admin change the UndoableStringBuilder and we check if update really happened
        admin.insert(0, "!!!");
        assertEquals(member1.getUn_st_member(),admin.getUndoableStringBuilder());
        assertEquals(member2.getUn_st_member(),admin.getUndoableStringBuilder());
        assertEquals(member3.getUn_st_member(),admin.getUndoableStringBuilder());
        //check if really admin4 is not in the list anymore
        assertEquals(admin.numOfMembers(),3);
        //unregister member3
        admin.unregister(member3);
        //admin change the UndoableStringBuilder and we check if update really happened
        admin.undo();
        assertEquals(member1.getUn_st_member(),admin.getUndoableStringBuilder());
        assertEquals(member2.getUn_st_member(),admin.getUndoableStringBuilder());
        //check if really admin3 is not in the list anymore
        assertEquals(admin.numOfMembers(),2);
        //unregister member2
        admin.unregister(member2);
        //admin change the UndoableStringBuilder and we check if update really happened
        admin.delete(7,9);
        assertEquals(member1.getUn_st_member(),admin.getUndoableStringBuilder());
        //check if really admin3 is not in the list anymore
        assertEquals(admin.numOfMembers(),1);
        //add to list member that already there - should do nothing!
        admin.register(member1);
        assertEquals(admin.numOfMembers(),1);
    }

    @Test
    public void JvmUtilities_part_B_test()
    {
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("member1", admin);
        ConcreteMember member2 = new ConcreteMember("member2", admin);
        ConcreteMember member3 = new ConcreteMember("member3", admin);
        ConcreteMember member4 = new ConcreteMember("member4", admin);
        //add new member to the admin list
        admin.register(member1);
        //one member in the list
        logger.info(()->JvmUtilities.objectFootprint(admin));
        admin.register(member2);
        //two member in the list
        logger.info(()->JvmUtilities.objectFootprint(admin));
        //insert
        admin.insert(0,"~");
        admin.register(member3);
        //three member in the list
        logger.info(()->JvmUtilities.objectFootprint(admin));
        admin.register(member4);
        //four member in the list
        logger.info(()->JvmUtilities.objectFootprint(admin));
        //append
        admin.append("welcome!!!");
        logger.info(()->JvmUtilities.objectFootprint(admin));
        //undo
        admin.undo();
        logger.info(()->JvmUtilities.objectFootprint(admin));

    }
}
