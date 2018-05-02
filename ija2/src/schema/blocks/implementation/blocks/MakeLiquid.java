package schema.blocks.implementation.blocks;

import schema.blocks.implementation.type.AbstractMaterial;
import schema.blocks.implementation.type.Type;
import schema.blocks.implementation.type.TypesFactory;

import static java.lang.Math.abs;

public class MakeLiquid extends Block {

    public MakeLiquid(int id) {
        super(Operation.MKLIQUID, id);
    }

    @Override
    public Operation getOperation() {
        return Block.Operation.MKLIQUID;
    }

    private void processingIce(Type material, Type resultMaterial, Type resultEnergy) {
        double joule = (-1)*material.getJoule();
        double delta = abs(material.getTemp() - material.getFreezeTemp());

        joule += material.getThermalConst()*material.getMass()*delta;
        joule += material.getFusionConst()*material.getMass();
        resultEnergy.setJoule(joule);
        resultMaterial.setState(AbstractMaterial.State.LIQUID);
        resultMaterial.setTemp(material.getFreezeTemp());

        this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
        this.setPortOutValue(portsOut.get(1).getId(), resultEnergy);
        return;
    }

    private void processingGas(Type material, Type resultMaterial, Type resultEnergy) {
        double joule = material.getJoule();
        double delta = abs(material.getTemp() - material.getGasTemp());

        joule += material.getThermalConst()*material.getMass()*delta;
        joule += material.getVaporisationConst()*material.getMass();
        resultEnergy.setJoule(joule);
        resultMaterial.setState(AbstractMaterial.State.LIQUID);
        resultMaterial.setTemp(material.getGasTemp());

        this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
        this.setPortOutValue(portsOut.get(1).getId(), resultEnergy);
        return;
    }

    @Override
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
                resultEnergy.setJoule(material.getJoule());

                this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
                this.setPortOutValue(portsOut.get(1).getId(), resultEnergy);
                return;
            }
            case GASS: {
                processingGas(material, resultMaterial, resultEnergy);
                return;
            }
        }
    }
}
