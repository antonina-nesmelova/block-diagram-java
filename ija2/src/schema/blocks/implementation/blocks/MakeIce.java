package schema.blocks.implementation.blocks;

import schema.blocks.implementation.type.AbstractMaterial;
import schema.blocks.implementation.type.Type;
import schema.blocks.implementation.type.TypesFactory;

import static java.lang.Math.abs;

public class MakeIce extends Block {

    public MakeIce(int id) {
        super(Operation.MKICE, id);
    }

    /**
     * Return operation make ice
     * @return make ice
     */
    public Operation getOperation() {
        return Operation.MKICE;
    }

    /**
     * Freezing of liquid and setting output ports
     * @param material material to be frozen
     * @param resultMaterial material to be returned
     * @param resultEnergy energy that will be released after freezing
     */
    private void processingLiquid(Type material, Type resultMaterial, Type resultEnergy) {
        double joule = material.getJoule() + resultEnergy.getJoule();
        double delta = abs(material.getTemp() - material.getFreezeTemp());

        joule += material.getThermalConst()*material.getMass()*delta;
        joule += material.getFusionConst()*material.getMass();
        resultEnergy.setJoule(joule);
        resultMaterial.setState(AbstractMaterial.State.ICE);
        resultMaterial.setTemp(material.getFreezeTemp());

        this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
        this.setPortOutValue(portsOut.get(1).getId(), resultEnergy);
        return;
    }
    /**
     * Making liquid from gas
     * @param material material to be frozen
     * @param resultMaterial material to be returned
     * @param resultEnergy energy that will be released after making liquid
     */
    private void processingGas(Type material, Type resultMaterial, Type resultEnergy) {
        double joule = material.getJoule() + resultEnergy.getJoule();
        double delta = abs(material.getTemp() - material.getGasTemp());

        joule += material.getThermalConst()*material.getMass()*delta;
        joule += material.getVaporisationConst()*material.getMass();
        resultEnergy.setJoule(joule);
        resultMaterial.setState(AbstractMaterial.State.LIQUID);
        resultMaterial.setTemp(material.getGasTemp());

        processingLiquid(material, resultMaterial, resultEnergy);
        return;
    }

    /**
     * Calculating of energy that will be released after making ice from material, setting output ports values
     */
    public void calculate(Type material, Type energy) {
        System.out.println("In calculate Ice");
        TypesFactory factory = new TypesFactory();
        System.out.println("In calc mkcice " + material.getMass());
        Type resultMaterial = factory.createMaterial(material.getType(), material.getMass(), material.getTemp());
        System.out.println("In calc mkcice " + resultMaterial.getMass());
        Type resultEnergy = factory.createMaterial(Type.type.ENERGY, 0, 0);

        switch (material.getState()) {
            case ICE: {
                resultEnergy.setJoule(material.getJoule());
                this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
                this.setPortOutValue(portsOut.get(1).getId(), resultEnergy);
                return;
            }
            case LIQUID: {
                processingLiquid(material, resultMaterial, resultEnergy);
                return;
            }
            case GASS: {
                processingGas(material, resultMaterial, resultEnergy);
                return;
            } default: return;
        }
    }
}
