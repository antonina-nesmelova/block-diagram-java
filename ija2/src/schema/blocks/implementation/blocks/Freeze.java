package schema.blocks.implementation.blocks;

import schema.blocks.implementation.type.AbstractMaterial;
import schema.blocks.implementation.type.Type;
import schema.blocks.implementation.type.TypesFactory;

import static java.lang.Math.abs;

public class Freeze extends Block{
    public Freeze(int id) {
        super(Operation.FREEZE, id);
    }

    /**
     * Freezing liquid
     * @param energy energy that will be removed from material
     * @param material liquid that will be processed
     * @return result material
     */
    private Type processingLiquid(double energy, Type material) {
        // pocet stupnu do teploty ledu
        double difference = abs( material.getTemp() - material.getFreezeTemp());
        //pocet stupnu na ktery muze se osudit material
        double delta = energy / (material.getThermalConst()* material.getMass());
        // pokud delta > dt - vyparovani
        if(delta >= difference) {
            double energyForFreezing = energy - material.getThermalConst()*material.getMass()*difference;
            material.setTemp(material.getFreezeTemp());

            energy = energyForFreezing - material.getFusionConst()*material.getMass();
            if (energy >= 0) {
                material.setState(AbstractMaterial.State.ICE);
                return processingIce(energy, material);
            } else {
                material.setState(AbstractMaterial.State.ICE);
                material.setJoule(abs(energy));
                return material;
            }
        } else { //jinak ostudime a vratime
            material.setTemp(material.getTemp() - delta);
            return material;
        }

    }

    /**
     * Freezing ice
     * @param energy energy that will be removed from material
     * @param material material that will be processed
     * @return result material
     */
    private Type processingIce(double energy, Type material) {
        double delta = energy / (material.getThermalConst()* material.getMass());
        material.setTemp(material.getTemp() - delta);
        return material;
    }

    /**
     * Calculating result material after freezing and set output port value
     * @param material material for operation
     * @param energy energy for operation
     */
    public void calculate(Type material, Type energy) {
        TypesFactory factory = new TypesFactory();
        double joule = energy.getJoule() + material.getJoule(); //energie plus vnitrni teplota materialu

        Type resultMaterial = factory.createMaterial(material.getType(), material.getMass(), material.getTemp());

        switch (material.getState()) {
            case GASS: {
                double delta = joule / (material.getThermalConst() * material.getMass()); //pocet stupnu na ktery muze se ohrat material
                // pocet stupnu do teploty mrazu
                double difference = abs(material.getTemp() - material.getGasTemp());
                // pokud delta > dt
                if (delta < difference) {
                    // ostudime material a vratime
                    resultMaterial.setTemp(resultMaterial.getTemp() - delta);
                    //return resultMaterial;
                    this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
                    return;
                }
                // odecteme energii pro studeni materialu do teploty tekutiny
                double energyForCondensation = joule - material.getThermalConst() * material.getMass() * difference;
                resultMaterial.setTemp(material.getFreezeTemp());
                // vypocitame energii ktera zustane po taveni
                double energyForFreezing = energyForCondensation - material.getVaporisationConst() * material.getMass();
                if (energyForFreezing >= 0) {
                    resultMaterial.setState(AbstractMaterial.State.LIQUID);
                    resultMaterial = processingLiquid(energyForFreezing, resultMaterial);
                    this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
                    return;

                } else { // pokud energie nestaci na kondenzaci - pricteme ji k vnitrni energii
                    resultMaterial.setState(AbstractMaterial.State.LIQUID);
                    resultMaterial.setJoule(abs(energyForFreezing));
                    this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
                    return;
                }
            }
            case LIQUID: {
                resultMaterial = processingLiquid(joule, resultMaterial);
                this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
                return;
            }
            case ICE: {
                resultMaterial = processingIce(joule, resultMaterial);
                this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
                return;
            }
            default: {
                this.setPortOutValue(portsOut.get(0).getId(), resultMaterial);
                return;
            }
        }
    }

    /**
     * Return operation freeze
     * @return freeze
     */
    public Block.Operation getOperation() {
        return Operation.FREEZE;
    }
}
