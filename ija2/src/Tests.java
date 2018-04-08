import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import schema.blocks.implementation.type.AbstractMaterial;
import schema.blocks.Block;
import schema.Schema;
import schema.blocks.implementation.type.Energy;
import schema.blocks.implementation.type.Water;

public class Tests {
    protected Schema schema = new Schema();

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testblock() {
        Block warm = schema.createBlock(Block.Operation.WARM);
        Block freeze = schema.createBlock(Block.Operation.FREEZE);

        AbstractMaterial water = new Water();
        water.setValues(0.5, 30);
        Energy energy = new Energy(1000);


        schema.setEnergy(warm, energy);
        schema.setEnergy(freeze, energy);

        Assert.assertEquals("Created blocks Warm has type WARM", warm.getOperation(), Block.Operation.WARM);
        Assert.assertEquals("Created blocks Freeze has type FREEZE", freeze.getOperation(), Block.Operation.FREEZE);
    }
}