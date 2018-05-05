package schema.blocks.implementation.blocks;

import schema.blocks.implementation.type.AbstractMaterial;
import schema.blocks.implementation.type.Type;
import schema.blocks.implementation.type.TypesFactory;

import static java.lang.Math.abs;

public class MakeGas extends Block {

    public MakeGas(int id) {
        super(Operation.MKGASS, id);
    }

    /**
     * Return operation make gas
     * @return make gas
     */
    public Operation getOperation() {
        return Operation.MKGASS;
    }

    /**
     * Vaporization of liquid and setting output ports
     * @param material material to be vaporized
     * @param resultMaterial material to be returned
     * @param resultEnergy energy to be used for vaporization
     */
    private void processingLiquid(Type material, Type resultMaterial, Type resultEnergy) {
        double joule = (-1)*material.getJoule() + resultEnergy.getJoule();
        double delta = abs(material.getTemp() - material.getGasTemp());

        joule += material.getThermalConst()*material.getMass()*delta;
        joule += material.getFusionConst()*material.getMass();
        resultEnergy.setJoule(joule);
        resultMaterial.setState(AbstractMaterial.State.GASS);
        resultMaterial.setTemp(material.getGasTemp());

        this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
        this.setPortOutValue(portsOut.get(1).getId(), resultEnergy);
        return;
    }
    /**
     * Making liquid from ice
     * @param material material to be vaporized
     * @param resultMaterial material to be returned
     * @param resultEnergy energy to be used for make liquid
     */
    private void processingIce(Type material, Type resultMaterial, Type resultEnergy) {
        double joule = material.getJoule()*(-1);
        material.setJoule(0);
        double delta = abs(material.getTemp() - material.getFreezeTemp());

        joule += material.getThermalConst()*material.getMass()*delta;
        joule += material.getFusionConst()*material.getMass();
        resultEnergy.setJoule(joule);
        resultMaterial.setState(AbstractMaterial.State.LIQUID);
        resultMaterial.setTemp(material.getFreezeTemp());

        processingLiquid(material, resultMaterial, resultEnergy);
        return;
    }

    /**
     * Calculating of energy that is needed to make gas from material, setting output ports values
     */
    public void calculate(Type material, Type energy) {
        TypesFactory factory = new TypesFactory();
        Type resultMaterial = factory.createMaterial(material.getType(), material.getMass(), material.getTemp());
        Type resultEnergy = factory.createMaterial(Type.type.ENERGY, 0, 0);

        switch (material.getState()) {
            case ICE: {
                processingIce(material, resultMaterial, resultEnergy);
                return;
            }
            case LIQUID: {
                processingLiquid(material, resultMaterial, resultEnergy);
                return;
            }
            case GASS: {
                this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
                this.setPortOutValue(portsOut.get(1).getId(), resultEnergy);
                return;
            } default: return;
        }
    }
}
