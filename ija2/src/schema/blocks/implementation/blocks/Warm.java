package schema.blocks.implementation.blocks;

import schema.blocks.implementation.type.AbstractMaterial;
import schema.blocks.implementation.type.Type;
import schema.blocks.implementation.type.TypesFactory;

import static java.lang.Math.abs;

public class Warm extends Block {
	
	public Warm(int id) {
		super(Operation.WARM);
		this.id = id;
	}

	private Type processingLiquid(double energy, Type material) {
        // pocet stupnu do teploty plynu
        double difference = abs( material.getTemp() - material.getGasTemp());
        //pocet stupnu na ktery muze se ohrat material
        double delta = energy / (material.getThermalConst()* material.getMass());
        // pokud delta > dt - vyparovani
        if(delta >= difference) {
            double energyForVaporization = energy - material.getThermalConst()*material.getMass()*difference;
            material.setTemp(material.getGasTemp());

            energy = energyForVaporization - material.getVaporisationConst()*material.getMass();
            if (energy >= 0) {
                material.setState(AbstractMaterial.State.GASS);
                return processingGas(energy, material);
            } else {
                material.setJoule(energy);
                return material;
            }
        } else { //jinak ohrame a vratime
            material.setTemp(material.getTemp() + delta);
            return material;
        }

    }

    private Type processingGas(double energy, Type material) {
        double delta = energy / (material.getThermalConst()* material.getMass());
        material.setTemp(material.getTemp() + delta);
        return material;
    }

	public Type calculate(Type material, Type energy) {
        TypesFactory factory = new TypesFactory();
	    double joule = energy.getJoule() + material.getJoule(); //energie plus vnitrni teplota materialu

        Type resultMaterial = factory.createMaterial(material.getType(), material.getMass(), material.getTemp());

        switch (material.getState()) {
            case ICE: {
                double delta = joule / (material.getThermalConst()* material.getMass()); //pocet stupnu na ktery muze se ohrat material
                // pocet stupnu do teploty mrazu
                double difference = abs( material.getTemp() - material.getFreezeTemp());
                // pokud delta > dt - taveni
                if(delta < difference) {
                    // ohrame material a vratime
                    resultMaterial.setTemp(resultMaterial.getTemp() + delta);
                    return resultMaterial;
                }
                // odecteme energii pro ohrati materialu do teploty taveni
                double energyForFusion = joule - material.getThermalConst()*material.getMass()*difference;
                resultMaterial.setTemp(material.getFreezeTemp());
                // vypocitame energii ktera zustane po taveni
                double energyForWarming = energyForFusion - material.getFusionConst()*material.getMass();
                if (energyForWarming >= 0) {
                    resultMaterial.setState(AbstractMaterial.State.LIQUID);
                    return processingLiquid(energyForWarming, resultMaterial);

                } else { // pokud energie nestaci na taveni - pricteme ji jako vnitrni energii
                    resultMaterial.setJoule(energyForWarming);
                    return resultMaterial;
                }
            }
            case LIQUID: {
                return processingLiquid(joule, resultMaterial);
            }
            case GASS: {
                return processingGas(joule, resultMaterial);
            }
            default: {
                return resultMaterial;
            }
        }


	}
	
	public Block.Operation getOperation() {
		return Operation.WARM;
	}
	
}
