/**
 * IJA 2017/2018: Testovaci trida pro ukol c. 2.
 * @authori xpirkl03, xnesme00
 */
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import schema.blocks.Block;
import schema.blocks.implementation.Schema;
import schema.window.AbstractFactory;

public class Ukol2Test {
	
	 protected Schema schema;
	
    @Before
    public void setUp() {
        schema = new Schema();
    }
    
    @Test
    public void testblock() {
        Block warm = schema.createBlock(Block.Operation.WARM);
    }
}
