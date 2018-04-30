import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import schema.blocks.implementation.type.AbstractMaterial;
import schema.blocks.implementation.blocks.Block;
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

        Assert.assertEquals("Created blocks Warm has type WARM", warm.getOperation(), Block.Operation.WARM);
        Assert.assertEquals("Created blocks Freeze has type FREEZE", freeze.getOperation(), Block.Operation.FREEZE);
    }

    @Test
    public void testtypes() {

        AbstractMaterial water = new Water();
        water.setValues(0.5, 30);
        Energy energy = new Energy();
        energy.setJoule(1000);

        Assert.assertEquals(1000, energy.getJoule(), 0.001);

        Assert.assertEquals(water.getTemp(), 30, 0.001);
        Assert.assertEquals(water.getMass(), 0.5, 0.001);

        Assert.assertEquals("Water is liquid in 30 digries", water.getState(), AbstractMaterial.State.LIQUID);

        water.setTemp(-10);
        Assert.assertEquals("Water is ice in -10 digries", water.getState(), AbstractMaterial.State.ICE);

        water.setTemp(120);
        Assert.assertEquals("Water is gas in 120 digries", water.getState(), AbstractMaterial.State.GASS);

        water.setValues(20, 50);
        Assert.assertEquals("Water is liquid in 50 digries", water.getState(), AbstractMaterial.State.LIQUID);
        Assert.assertEquals(water.getTemp(), 50, 0.001);
        Assert.assertEquals(water.getMass(), 20, 0.001);
    }

    @Test
    public void testports() {
        Block warm = schema.createBlock(Block.Operation.WARM);
        Block freeze = schema.createBlock(Block.Operation.FREEZE);

        AbstractMaterial water = new Water();
        water.setValues(0.5, 30);
        Energy energy = new Energy(2000, 100);
        energy.setJoule(1000);

        Assert.assertTrue("Set type Water to port of Warm block",schema.setPortValue(warm, water, 0));
        Assert.assertTrue("Set type Energy to port of Warm block",schema.setPortValue(warm, energy, 1));

        Assert.assertTrue("Set type Water to port of Freeze block",schema.setPortValue(freeze, water, 0));
        Assert.assertTrue("Set type Energy to port of Freeze block",schema.setPortValue(freeze, energy, 1));

        Assert.assertEquals("Warm block has Water on its zero port", warm.getPortValue(0), water);
        Assert.assertEquals("Warm block has Energy on its first port", warm.getPortValue(1), energy);

        Assert.assertEquals("Freeze block has Water on its zero port", warm.getPortValue(0), water);
        Assert.assertEquals("Freeze block has Energy on its first port", warm.getPortValue(1), energy);

    }
}